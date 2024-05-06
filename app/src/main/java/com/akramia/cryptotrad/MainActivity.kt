package com.akramia.cryptotrad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.akramia.cryptotrad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        val navController = navHostFragment!!.findNavController()

        //login ekranda bottombar gozukmesin ve sifreni dogru yazarsa home sayfasina kecince bottom bar gozukur.
        navController.addOnDestinationChangedListener(object :
            NavController.OnDestinationChangedListener {
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                if (destination.id == R.id.splashFragment || destination.id == R.id.logRegFragment || destination.id == R.id.loginFragment || destination.id == R.id.signupFragment || destination.id == R.id.recoveryFragment) {
                    binding.bottomBar.visibility = View.GONE
                } else {
                    binding.bottomBar.visibility = View.VISIBLE

                }
            }

        })

        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(R.menu.bottom_nav_menu)
        binding.bottomBar.setupWithNavController(popupMenu.menu, navController)


    }
}