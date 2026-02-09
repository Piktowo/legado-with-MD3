package io.legado.app.ui.book.read.config

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import io.legado.app.base.adapter.ItemViewHolder
import io.legado.app.base.adapter.RecyclerAdapter
import io.legado.app.constant.EventBus
import io.legado.app.databinding.ItemBgImageBinding
import io.legado.app.help.config.ReadBookConfig
import io.legado.app.help.glide.ImageLoader
import io.legado.app.utils.postEvent

class BgAdapter(context: Context, val textColor: Int) :
    RecyclerAdapter<String, ItemBgImageBinding>(context) {

    override fun getViewBinding(parent: ViewGroup): ItemBgImageBinding {
        return ItemBgImageBinding.inflate(inflater, parent, false)
    }

    override fun convert(
        holder: ItemViewHolder,
        binding: ItemBgImageBinding,
        item: String,
        payloads: MutableList<Any>
    ) {
        binding.run {
            tvName.text = item.substringBeforeLast(".")
            val assetUri = Uri.parse("file:///android_asset/bg/${item}")
            ImageLoader.load(
                context,
                assetUri
            )
                .centerCrop()
                .into(ivBg)
        }
    }

    override fun registerListener(holder: ItemViewHolder, binding: ItemBgImageBinding) {
        holder.itemView.apply {
            this.setOnClickListener {
                getItemByLayoutPosition(holder.layoutPosition)?.let {
                    ReadBookConfig.durConfig.setCurBg(1, it)
                    postEvent(EventBus.UP_CONFIG, arrayListOf(1))
                }
            }
        }
    }
}
