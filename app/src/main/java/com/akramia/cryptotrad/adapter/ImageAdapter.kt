import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.akramia.cryptotrad.R

class ImageAdapter(private val images: List<Int>, private val urls: List<String>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position], urls[position])
    }

    override fun getItemCount(): Int = images.size

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(imageResId: Int, imageUrl: String) {
            imageView.setImageResource(imageResId)

            // Resme tıklandığında ilgili URL'ye yönlendirme işlemi
            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imageUrl))
                context.startActivity(intent)
            }
        }
    }
}