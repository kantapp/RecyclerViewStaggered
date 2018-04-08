package codingwithmitch.com.recyclerviewstaggered

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import java.lang.reflect.Array
import java.util.ArrayList

/**
 * Created by User on 1/17/2018.
 */

class StaggeredRecyclerViewAdapter(private val mContext: Context, names: ArrayList<String>, imageUrls: ArrayList<String>) : RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder>() {

    private var mNames = ArrayList<String>()
    private var mImageUrls = ArrayList<String>()

    init {
        mNames = names
        mImageUrls = imageUrls
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)

        Glide.with(mContext)
                .load(mImageUrls[position])
                .apply(requestOptions)
                .into(holder.image)

        holder.name.text = mNames[position]

        holder.image.setOnClickListener {
            Log.d(TAG, "onClick: clicked on: " + mNames[position])
            Toast.makeText(mContext, mNames[position], Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var image: ImageView
        internal var name: TextView

        init {
            this.image = itemView.findViewById(R.id.imageview_widget)
            this.name = itemView.findViewById(R.id.name_widget)
        }
    }

    companion object {

        private val TAG = "StaggeredRecyclerViewAd"
    }
}
