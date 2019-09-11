package com.dikoding.picodiploma.mytourguidebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dikoding.picodiploma.mytourguidebook.ArticleActivity;
import com.dikoding.picodiploma.mytourguidebook.R;
import com.dikoding.picodiploma.mytourguidebook.model.Wisata;

import java.util.ArrayList;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ListViewHolder> {
    private static final String TAG = "ListWisataAdapter";
    private ArrayList<Wisata> wisatas;
    private Context mContext;

    /**
     * @param context
     * @param wisatas
     */
    public ListWisataAdapter(Context context, ArrayList<Wisata> wisatas) {
        mContext = context;
        this.wisatas = wisatas;
    }

    /**
     * @param viewGroup
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_article, viewGroup, false);
        return new ListViewHolder(view);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        Wisata wisata = wisatas.get(position);

        Glide.with(holder.itemView.getContext())
                .load(wisata.getImage())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgPhoto);

        holder.titleName.setText(wisatas.get(position).getTitle());
        holder.summary.setText(wisatas.get(position).getSummary());
        holder.locationName.setText(wisatas.get(position).getLocation());

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data for detail article
                Intent intent = new Intent(mContext, ArticleActivity.class);
                intent.putExtra("image_url", wisatas.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("title", wisatas.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("posted_time", wisatas.get(holder.getAdapterPosition()).getPosted_time());
                intent.putExtra("posted_by", wisatas.get(holder.getAdapterPosition()).getPosted_by());
                intent.putExtra("content", wisatas.get(holder.getAdapterPosition()).getDescription());
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        LinearLayout parentlayout;
        ImageView imgPhoto;
        TextView titleName, summary, locationName;

        ListViewHolder(View itemView) {
            super(itemView);
            parentlayout = itemView.findViewById(R.id.parent_layout);
            imgPhoto = itemView.findViewById(R.id.item_wisata_photo);
            titleName = itemView.findViewById(R.id.item_wisata_title);
            summary = itemView.findViewById(R.id.item_wisata_summary);
            locationName = itemView.findViewById(R.id.item_wisata_location);
        }
    }
}