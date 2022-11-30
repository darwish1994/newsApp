package com.link.newsapp.common.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GeneralListAdapter<T, VB : ViewBinding> : RecyclerView.Adapter<BaseHolder<T, VB>>() {

    private val mData = arrayListOf<T>()
    private var listener: ItemClickListener? = null

    fun setListener(listener: ItemClickListener?) {
        this.listener = listener
    }

    fun swipeData(data: List<T>) {
        val diffUtil = GeneralDiffUtil(mData, data)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        diffResults.dispatchUpdatesTo(this)
        mData.apply {
            clear()
            addAll(data)
        }
    }

    fun appendData(data: List<T>) {
        val diffUtil = GeneralDiffUtil(mData, data)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        diffResults.dispatchUpdatesTo(this)
        mData.apply {
            addAll(data)
        }
    }


    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: BaseHolder<T, VB>, position: Int) {
        holder.bind(mData[position])
        holder.itemView.setOnClickListener {
            listener?.onItemClicked(mData[position])
        }
    }


}