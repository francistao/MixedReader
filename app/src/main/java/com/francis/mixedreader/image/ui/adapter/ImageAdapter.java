package com.francis.mixedreader.image.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.francis.mixedreader.R;
import com.francis.mixedreader.model.ImageBean;
import com.francis.mixedreader.news.ui.adapter.NewsAdapter;
import com.francis.mixedreader.utils.ImageLoaderUtils;
import com.francis.mixedreader.utils.ToolsUtil;
import java.util.List;

/**
 * @author taoc @ Zhihu Inc.
 * @since 09-22-2016
 *
 * 图片界面的 适配器
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder>{

	private List<ImageBean> mData;
	private Context mContext;
	private int mMaxWidth;
	private int mMaxHeight;

	private OnItemClickListener mOnItemClickListener;

	public ImageAdapter(Context context) {
		mContext = context;
		mMaxWidth = ToolsUtil.getWidthInPx(mContext) - 20;
		mMaxHeight = ToolsUtil.getHeightInPx(mContext) - ToolsUtil.getStatusHeight(mContext) -
				ToolsUtil.dip2px(mContext, 96);
	}

	public void setData(List<ImageBean> data){
		this.mData = data;
		notifyDataSetChanged();
	}

	@Override
	public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
		ItemViewHolder vh = new ItemViewHolder(view);
		return vh;
	}

	@Override
	public void onBindViewHolder(ItemViewHolder holder, int position) {
		ImageBean imageBean = mData.get(position);
		if(imageBean == null){
			return;
		}
		holder.title.setText(imageBean.getTitle());
		float scale = (float)imageBean.getWidth() / (float)mMaxWidth;
		int height = (int) (imageBean.getHeight() / scale);
		if(height > mMaxHeight){
			height = mMaxHeight;
		}
		holder.image.setLayoutParams(new LinearLayout.LayoutParams(mMaxWidth, height));
		ImageLoaderUtils.display(mContext, holder.image, imageBean.getThumburl());
	}

	@Override
	public int getItemCount() {

		if(mData == null){
			return 0;
		}
		return mData.size();
	}

	public ImageBean getItem(int position){
		return mData == null ? null : mData.get(position);
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
