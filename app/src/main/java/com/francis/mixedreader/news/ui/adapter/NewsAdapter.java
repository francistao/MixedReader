package com.francis.mixedreader.news.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.francis.mixedreader.R;
import com.francis.mixedreader.model.NewsBean;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-19-2016
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_FOOTER = 1;

	private List<NewsBean> mData;
	private boolean mShowFooter = true;
	private Context mContext;

	private OnItemClickListener mOnItemClickListener;

	public NewsAdapter(Context context) {
		mContext = context;
	}

	public void setData(List<NewsBean> data){
		this.mData = data;
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		// 最后一个 item 设置为 FooterView
		if(!mShowFooter){
			return TYPE_ITEM;
		}
		if(position + 1 == getItemCount()){
			return TYPE_FOOTER;
		}else {
			return TYPE_ITEM;
		}
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if(viewType == TYPE_ITEM){
			View view = LayoutInflater.from(parent.getContext())
					.inflate(R.layout.item_news, parent, false);
			ItemViewHolder viewHolder = new ItemViewHolder(view);
			return viewHolder;
		}else {
			View view = LayoutInflater.from(parent.getContext()).inflate(
				R.layout.footer, null);
			view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT));
			return new FooterViewHolder(view);
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		if(holder instanceof ItemViewHolder){

			NewsBean newsBean = mData.get(position);
			if(newsBean == null){
				return;
			}
			((ItemViewHolder) holder).title.setText(newsBean.getTitle());
			((ItemViewHolder) holder).desc.setText(newsBean.getDigest());

		}
	}

	@Override
	public int getItemCount() {
		return 0;
	}


	public interface OnItemClickListener{
		void OnItemClick(View view, int position);
	}

	public class FooterViewHolder extends RecyclerView.ViewHolder{

		public FooterViewHolder(View itemView) {
			super(itemView);
		}
	}

	public class ItemViewHolder extends RecyclerView.ViewHolder{

		public TextView title;
		public TextView desc;
		public ImageView newsImg;

		public ItemViewHolder(View itemView) {
			super(itemView);
		}
	}
}
