package com.ndt.ductam.mp3app.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ndt.ductam.mp3app.Model.Baihat;
import com.ndt.ductam.mp3app.Model.Playlist;
import com.ndt.ductam.mp3app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BaihathayAdapter extends ArrayAdapter<Baihat> {

    Context context;
    ArrayList<Baihat> baihatArrayList;

    public BaihathayAdapter(@NonNull Context context, int resource, @NonNull List<Baihat> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txtten, txtcasi;
        ImageView imghinh, imgluotthich;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        ViewHolder viewHolderbaihathay = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_bai_hat_hay, null);
            viewHolderbaihathay = new ViewHolder();
            viewHolderbaihathay.txtten = convertView.findViewById(R.id.textviewtenbaihathay);
            viewHolderbaihathay.txtcasi = convertView.findViewById(R.id.textviewcasibaihathay);
            viewHolderbaihathay.imghinh = convertView.findViewById(R.id.imageviewbaihathay);
            viewHolderbaihathay.imgluotthich = convertView.findViewById(R.id.imageviewluotthich);

            convertView.setTag(viewHolderbaihathay);
        }
        else{
            viewHolderbaihathay = (BaihathayAdapter.ViewHolder) convertView.getTag();
        }
        final Baihat baihat = getItem(position);
        Picasso.with(getContext()).load(baihat.getHinhBaiHat()).into(viewHolderbaihathay.imghinh);
        viewHolderbaihathay.txtten.setText(baihat.getTenBaiHat());
        viewHolderbaihathay.txtcasi.setText(baihat.getCaSi());

        /*viewHolderbaihathay.imgluotthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolderbaihathay.imgluotthich.setImageResource(R.drawable.iconloved);

            }
        });*/

        return convertView;
    }


    /*Context context;
    ArrayList<Baihat> baihatArrayList;

    public BaihathayAdapter(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hay, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Baihat baihat = baihatArrayList.get(position);
        viewHolder.txtcasi.setText(baihat.getCaSi());
        viewHolder.txtten.setText(baihat.getTenBaiHat());
        Picasso.with(context).load(baihat.getHinhBaiHat()).into(viewHolder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten, txtcasi;
        ImageView imghinh, imgluotthich;
        public ViewHolder(View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihathay);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathay);
            imghinh = itemView.findViewById(R.id.imageviewbaihathay);
            imgluotthich= itemView.findViewById(R.id.imageviewluotthich);
        }
    }*/
}
