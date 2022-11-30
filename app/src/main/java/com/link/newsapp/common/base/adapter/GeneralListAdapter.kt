package com.link.newsapp.common.base.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GeneralListAdapter<T,VB:ViewBinding> : RecyclerView.Adapter<BaseHolder<T, VB>>(){

    private val mData = arrayListOf<T>()

    fun swipeData(data:List<T>){
        val diffUtil = GeneralDiffUtil(mData,data)
        val diffResults =  DiffUtil.calculateDiff(diffUtil)
        diffResults.dispatchUpdatesTo(this)
        mData.apply {
            clear()
            addAll(data)
        }
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: BaseHolder<T, VB>, position: Int) {
        holder.bind(mData[position])
    }




}