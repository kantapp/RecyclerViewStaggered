package codingwithmitch.com.recyclerviewstaggered

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.widget.LinearLayout

import java.lang.reflect.Array
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val mImageUrls = ArrayList<String>()
    private val mNames = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initImageBitmaps()
    }

    private fun initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.")

        mImageUrls.add("http://cdn.wonderfulengineering.com/wp-content/uploads/2016/01/Desktop-Wallpaper-4.jpg")
        mNames.add("Havasu Falls")

        mImageUrls.add("https://wallpaperbrowse.com/media/images/745667.jpg")
        mNames.add("Trondheim")

        mImageUrls.add("https://www.planwallpaper.com/static/images/4f1731e34d4a968a7cd9a567bf691d34--wallpaper-palm-trees-clouds-wallpaper-iphone.jpg")
        mNames.add("Portugal")

        mImageUrls.add("https://images.unsplash.com/photo-1445264918150-66a2371142a2?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=79730c9ec106e3ccee026c648c624e5f&w=1000&q=80")
        mNames.add("Rocky Mountain National Park")


        mImageUrls.add("https://i.pinimg.com/736x/c8/1e/96/c81e969bddc3fd049d03929c6b31ffcd--screen-wallpaper-iphone--wallpaper.jpg")
        mNames.add("Mahahual")

        mImageUrls.add("https://www.planwallpaper.com/static/images/cdb737da7586dfb3021a277d0b8c1786--iphone--wallpaper-wallpaper-ideas.jpg")
        mNames.add("Frozen Lake")


        mImageUrls.add("https://images.unsplash.com/photo-1500462918059-b1a0cb512f1d?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=0e3917e828b7c2502b0041813eff1294&w=1000&q=80")
        mNames.add("White Sands Desert")

        mImageUrls.add("https://images.alphacoders.com/846/thumb-1920-84631.jpg")
        mNames.add("Austrailia")

        mImageUrls.add("https://404store.com/2018/04/06/21e3737.jpg")
        mNames.add("Washington")

        initRecyclerView()

    }

    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val staggeredRecyclerViewAdapter = StaggeredRecyclerViewAdapter(this, mNames, mImageUrls)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.adapter = staggeredRecyclerViewAdapter
    }

    companion object {

        private val TAG = "MainActivity"
        private val NUM_COLUMNS = 2
    }
}















