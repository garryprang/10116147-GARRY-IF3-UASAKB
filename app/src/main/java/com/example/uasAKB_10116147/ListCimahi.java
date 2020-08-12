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

public class ListCimahi  extends AppCompatActivity implements WisataAdapter.OnRsListener{
    private String TAG = ListCimahi.class.getSimpleName();
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
        dataList.add(new wisata1("Alam Wisata Cimahi\n", "Jl. Kolonel Masturi KM. 4 No.157, Cipageran, Kec. Cimahi Utara, Kota Cimahi, Jawa Barat 40511\n",-6.840439, 107.551058));
        dataList.add(new wisata1("All About Strawberry\n", "Jl. Cihanjuang No. 24, Cibabat, Kec. Cimahi Utara, Kota Cimahi, Jawa Barat 40513\n",-6.864219, 107.562979));
        dataList.add(new wisata1("Curug Tunan Katumiri\n", "Kampung Dangdeur Desa, Sanca, Kec. Ciater, Kab. Subang, Jawa Barat 41281\n",-6.713585, 107.698491));
        dataList.add(new wisata1("Kampung Buyut Cipageran\n", "Jl. Kolonel Masturi No.Km. 3, Cipageran, Kec. Cimahi Utara, Kota Cimahi, Jawa Barat 40511\n",-6.848206, 107.548752));
    }

    @Override
    public void onRsClick(int position) {
        Log.d(TAG,"OnRsClick : is clicked"+position);
        Intent intent = new Intent(ListCimahi.this, wisata.class);
        intent.putExtra("nama", dataList.get(position).getNama());
        intent.putExtra("alamat", dataList.get(position).getAlamat());
        intent.putExtra("lat", dataList.get(position).getLat());
        intent.putExtra("lng", dataList.get(position).getLng());

        startActivity(intent);
    }
}
