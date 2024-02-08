package com.example.inouterspace.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.inouterspace.databinding.CrewItemBinding


class CrewAdapter() : ListAdapter<CrewMemberUiModel, CrewAdapter.CrewViewHolder>(DiffCallback) {

    inner class CrewViewHolder(
        private val binding: CrewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CrewMemberUiModel) {
            with(binding) {
                itemImage.load(item.imageUrl)
                itemNameAgency.text = item.fullName + ", " + item.agency
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder =
        CrewViewHolder(
            CrewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) =
        holder.bind(getItem(position))

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<CrewMemberUiModel>() {
            override fun areItemsTheSame(oldItem: CrewMemberUiModel, newItem: CrewMemberUiModel) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: CrewMemberUiModel, newItem: CrewMemberUiModel) = oldItem == newItem
        }
    }
}