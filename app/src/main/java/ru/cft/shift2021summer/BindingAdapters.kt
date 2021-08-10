//package ru.cft.shift2021summer
//
//
//import android.provider.Settings.Global.getString
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.core.net.toUri
//
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import ru.cft.shift2021summer.data.network.CountryData
//import ru.cft.shift2021summer.presentation.overview.CountryLinearAdapter
//
//@BindingAdapter("imageUrl")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    imgUrl?.let {
//        val imgUri = it.toUri().buildUpon().scheme("https").build()
//        Glide.with(imgView.context)
//            .load(imgUri)
//            .into(imgView)
//    }
//}
//
//@BindingAdapter("nameCo")
//fun bindNameCountry(txtView: TextView, txtFormat: String?) {
//    val strToFormat = txtView.resources.getString(R.string.name_country, txtFormat)
//    txtView.text = strToFormat
//}
//
//@BindingAdapter("nameReg")
//fun bindNameRegion(txtView: TextView, txtFormat: String?) {
//    val strToFormat = txtView.resources.getString(R.string.name_region, txtFormat)
//    txtView.text = strToFormat
//}
//
//@BindingAdapter("listData")
//fun bindRecyclerView(recyclerView: RecyclerView, data: List<CountryData>?){
//    val adapter = recyclerView.adapter as CountryLinearAdapter
//    adapter.submitList(data)
//}