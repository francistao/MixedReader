package com.francis.mixedreader.image.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.francis.mixedreader.R;
import com.francis.mixedreader.model.ImageBean;
import com.francis.mixedreader.news.ui.adapter.NewsAdapter;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-22-2016
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder>{

	private List<ImageBean> mData;
	private Context mContext;
	private int mMaxWidth;
	private int mMaxHeight;

	private OnItemClickListener mOnItemClickListener;

	public ImageAdapter(Context context) {
		mContext = context;

	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
		ItemViewHolder vh = new ItemViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(ItemViewHolder holder, int position) {

	}


	@Override
	public int getItemCount() {
		return 0;
	}

	private interface OnItemClickListener{
		void onItemClick(View view, int position);
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener){
		this.mOnItemClickListener = mOnItemClickListener;
	}



	public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		public TextView title;
		public ImageView image;

		public ItemViewHolder(View itemView) {
			super(itemView);
			title = (TextView) itemView.findViewById(R.id.tvTitle);
			image = (ImageView) itemView.findViewById(R.id.ivImage);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			mOnItemClickListener.onItemClick(view, this.getPosition());
		}
	}
}
