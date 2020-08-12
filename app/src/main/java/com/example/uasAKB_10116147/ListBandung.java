package com.example.uasAKB_10116147;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Tanggal  Pengerjaan  : 7-11 Agustus 2020
// NIM	            	: 10116147
// Nama                 : Garry Prang
// Kelas	            : IF-3

public class ListBandung extends AppCompatActivity implements WisataAdapter.OnRsListener{
    private String TAG = ListBandung.class.getSimpleName();
    private RecyclerView recyclerView;
    private WisataAdapter adapter;
    private ArrayList<wisata1> dataList = new ArrayList<>();
    private ProgressDialog pDialog;
    TextView nama_wisata,alamat_wisata;
    private static final int REQUEST_CALL = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list2);

        addData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        nama_wisata = (TextView) findViewById(R.id.txt_nama_wisata);
        alamat_wisata = (TextView) findViewById(R.id.txt_alamat);

        recyclerView.setHasFixedSize(true);
        adapter = new WisataAdapter(dataList,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    private void addData() {
        dataList = new ArrayList<>();
        dataList.add(new wisata1("Gedung Sate\n", "Jl. Diponegoro No. 22, Citarum, Kec. Bandung Wetan, Kota Bandung, Jawa Barat 40115\n",-6.902462, 107.618810));
        dataList.add(new wisata1("Jalan Braga\n", "Jl. Braga No. 58-46, Braga, Kec. Sumur Bandung, Kota Bandung, Jawa Barat 40111\n",-6.917500, 107.609355));
        dataList.add(new wisata1("Taman Hutan Raya Ir. H. Djuanda\n", "Kompleks Tahura, Jl. Ir. H. Juanda No. 99, Ciburial, Kec. Cimenyan, Kota Bandung, Jawa Barat 40198\n",-6.856549, 107.632656));
        dataList.add(new wisata1("Trans Studio Bandung\n", "Jl. Jendral Gatot Subroto No. 289A, Cibangkong, Batununggal, Kota Bandung, Jawa Barat 40273\n",-6.925073, 107.636479));
    }

    @Override
    public void onRsClick(int position) {
        Log.d(TAG,"OnRsClick : is clicked"+position);
        Intent intent = new Intent(ListBandung.this, wisata.class);
        intent.putExtra("nama", dataList.get(position).getNama());
        intent.putExtra("alamat", dataList.get(position).getAlamat());
        intent.putExtra("lat", dataList.get(position).getLat());
        intent.putExtra("lng", dataList.get(position).getLng());

        startActivity(intent);
    }
}
