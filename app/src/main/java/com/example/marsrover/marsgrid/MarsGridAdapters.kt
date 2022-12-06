package com.example.marsrover.marsgrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrover.R
import com.example.marsrover.databinding.ItemviewBinding
import com.example.marsrover.models.MarsModels

//class MarsGridAdapters {
//}


class MarsGridAdapters( private val onClickListener: OnClickListener ) :
    ListAdapter<MarsModels,
            MarsGridAdapters.MarsPropertyViewHolder>(DiffCallback) {


    class MarsPropertyViewHolder(private var binding: ItemviewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsModels) {
            binding.url = marsProperty.img_src
            // This is important, because it forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<MarsModels>() {
        override fun areItemsTheSame(oldItem: MarsModels, newItem: MarsModels): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsModels, newItem: MarsModels): Boolean {
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MarsPropertyViewHolder {
//        val layout = LayoutInflater
//
//            .from(parent.context)
//            .inflate(R.layout.itemview, parent, false)

        val binding: ItemviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.itemview, parent, false
        )

        return MarsPropertyViewHolder(binding)


    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }


    class OnClickListener(val clickListener: (marsProperty:MarsModels) -> Unit) {
        fun onClick(marsProperty: MarsModels) = clickListener(marsProperty)
    }
}
















































































