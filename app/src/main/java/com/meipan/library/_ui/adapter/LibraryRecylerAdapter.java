package com.meipan.library._ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.meipan.library.R;


/**
 * Created by vaio on 2016/3/14.
 */
public class LibraryRecylerAdapter extends RecyclerView.Adapter<LibraryRecylerAdapter.ViewHolder> {

    private Context context;
    public String[] datas = null;

    public LibraryRecylerAdapter(Context context, String[] datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library, parent, false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView jieshao;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.item_ivimage);
            title= (TextView) itemView.findViewById(R.id.item_tvname);
            jieshao= (TextView) itemView.findViewById(R.id.item_neirong);
        }
    }
}
