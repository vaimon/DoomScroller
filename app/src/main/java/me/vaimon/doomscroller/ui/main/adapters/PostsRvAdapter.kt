package me.vaimon.doomscroller.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vaimon.doomscroller.data.models.Post
import me.vaimon.doomscroller.databinding.ItemPostBinding

class PostsRvAdapter(
    private val onClickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<PostsRvAdapter.ViewHolder>() {
    private val items = mutableListOf<Post>()

    private val mOnClickListener = View.OnClickListener{
        val item = it.tag as Post
        onClickListener?.onPostClick(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.title.text = item.title
        holder.body.text = item.body
        
        onClickListener?.also {
            with(holder.itemView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }
        }
    }

    fun setItems(items: List<Post>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val body = binding.body
    }

    interface OnItemClickListener {
        fun onPostClick(post: Post)
    }
}