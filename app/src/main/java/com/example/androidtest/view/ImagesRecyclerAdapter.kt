package com.example.androidtest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.core.net.toUri
import coil.load
import com.example.androidtest.R
import com.example.androidtest.data.ImageDataModel
import com.example.androidtest.databinding.RecyclerItemBinding

/**
 * Images recycler adapter. Describes view properties for Image cells within Recycler Grid.
 *
 * @author Nicholas Almeida
 */
class ImagesRecyclerAdapter: ListAdapter<ImageDataModel, ImagesRecyclerAdapter.ViewHolder>(ImageDataModelComparator()) {
    /**
     * View holder for Images Recycler.
     *
     * @property binding View binding for Recycler Item
     */
    class ViewHolder(val binding: RecyclerItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUri = getItem(position).link.toUri().buildUpon().scheme("https").build()
        holder.binding.imageCell.load(imgUri) {
            this.size(200)
            placeholder(R.drawable.animated_loading)
            error(R.drawable.ic_baseline_error_outline_24)
        }
    }

    /**
     * Image data model comparator
     */
    class ImageDataModelComparator: DiffUtil.ItemCallback<ImageDataModel>(){
        override fun areItemsTheSame(oldItem: ImageDataModel, newItem: ImageDataModel) =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: ImageDataModel, newItem: ImageDataModel) =
            oldItem == newItem
    }
}