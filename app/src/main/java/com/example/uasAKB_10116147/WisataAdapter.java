package com.example.uasAKB_10116147;

import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

// Tanggal  Pengerjaan  : 7-11 Agustus 2020
// NIM	            	: 10116147
// Nama                 : Garry Prang
// Kelas	            : IF-3

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.wisataViewHolder> {
    private ArrayList<wisata1> dataList = new ArrayList<>();
    private OnRsListener mOnRsListener;

    protected Cursor cursor;
    private static final int REQUEST = 112;

    public WisataAdapter(ArrayList<wisata1> dataList, OnRsListener OnRsListener) {
        this.dataList = dataList;

        this.mOnRsListener = OnRsListener;
    }

    @NonNull
    @Override
    public wisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_rs, parent, false);*/
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wisata, parent, false);

        return new wisataViewHolder(view,mOnRsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final WisataAdapter.wisataViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtalamat.setText(dataList.get(position).getAlamat());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class wisataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout parentLayout;
        OnRsListener OnRsListener;
        TextView txtNama, txtalamat;
        public TextView buttonViewOption;
        private static final int REQUEST_CALL = 1;

        public wisataViewHolder(@NonNull View itemView, OnRsListener OnRsListener) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_wisata);
            txtalamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            mOnRsListener = OnRsListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnRsListener.onRsClick(getAdapterPosition());
        }
    }
    public interface OnRsListener{
        void onRsClick(int position);
    }
}