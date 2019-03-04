package com.example.rick.project1201_picasso;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private LayoutInflater mInflater;

    private ClickListener mClickListener;

    private Picasso mPicasso;

    private Integer imageWidth;

    public ImagesAdapter(@NonNull Context context, Integer imageWidth) {
        mInflater = LayoutInflater.from(context);
        mPicasso = Picasso.with(context);
        this.imageWidth = imageWidth;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        ViewHolder viewHolder = new ViewHolder(mInflater.inflate(R.layout.view_list_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        mPicasso.cancelRequest(holder.imageView);
        holder.imageView.setImageBitmap(null);
        holder.progressBar.setVisibility(View.VISIBLE);
        mPicasso
                .load(ImageService.getImageURL(position))
                .placeholder(R.drawable.placeholder)
                .resize(imageWidth, imageWidth)
                .centerCrop()
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return ImageService.getImagesCount();
    }



    public void setOnItemClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final ImageView imageView;
        public ProgressBar progressBar;

        public ViewHolder(final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.view_image);
            itemView.setOnClickListener(this);

            progressBar = itemView.findViewById(R.id.view_progress);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onItemClick(getAdapterPosition());
            }
        }

    }

    public interface ClickListener {
        void onItemClick(int position);
    }
}
