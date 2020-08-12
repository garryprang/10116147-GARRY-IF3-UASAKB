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

public class ListKabBandung  extends AppCompatActivity implements WisataAdapter.OnRsListener{
    private String TAG = ListKabBandung.class.getSimpleName();
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
        dataList.add(new wisata1("Air Terjun Pelangi\n", "Jl. Kolonel Masturi No. 325, Kertawangi, Kec. Cisarua, Kab. Bandung Barat, Jawa Barat 40551\n",-6.799187, 107.577520));
        dataList.add(new wisata1("Bukit Gantole Cililin\n", "Singajaya, Kec. Cihampelas, Kab. Bandung Barat, Jawa Barat 40562\n",-6.958839, 107.471283));
        dataList.add(new wisata1("Ciwangun Indah Camp\n", "Cihanjuang Rahayu, Kec. Parongpong, Kab. Bandung Barat, Jawa Barat 40559\n",-6.791655, 107.581348));
        dataList.add(new wisata1("Curug Bugbrug\n", "Kertawangi, Kec. Cisarua, Kab. Bandung Barat, Jawa Barat 40551\n",-6.792087, 107.580107));
        dataList.add(new wisata1("Curug Malela\n", "Sindangjaya, Gununghalu, Kab. Bandung Barat, Jawa Barat\n",-7.018238, 107.207214));
        dataList.add(new wisata1("Dusun Bambu\n", "Jl. Kolonel Masturi, Kertawangi, Kec. Cisarua, Kab. Bandung Barat, Jawa Barat 40551\n",-6.789460, 107.578828));
        dataList.add(new wisata1("Farm House Susu Lembang\n", "Jl. Raya Lembang No.108, Gudangkahuripan, Lembang, Kab. Bandung Barat, Jawa Barat 40391\n",-6.832950, 107.605711));
        dataList.add(new wisata1("Gunung Putri\n", "Jl. Gunung Putri No. 184, Jayagiri, Lembang, Kab. Bandung Barat, Jawa Barat 40391\n",-6.803883, 107.627336));
        dataList.add(new wisata1("Gunung Tangkuban Parahu\n", "Jl. Tangkuban Perahu, Cikahuripan, Lembang, Kab. Bandung Barat, Jawa Barat\n",-6.759621,107.609775));
        dataList.add(new wisata1("Puncak Eurad Pingping\n", "Cibodas-Ciater, Wangunharja, Lembang, Kab. Bandung Barat, Jawa Barat 40391\n",-6.791334, 107.681780));
        dataList.add(new wisata1("Puncak Rindu Gunung Bendera\n", "Kampung Pojok Desa, Jayamekar, Padalarang, Kab. Bandung Barat, Jawa Barat 40553\n",-6.848649, 107.455409));
        dataList.add(new wisata1("Sanghyang Heuleut\n", "Cipanas, Rajamandala Kulon, Kec. Cipatat, Kab. Bandung Barat, Jawa Barat 40554\n",-6.876460, 107.342208));
        dataList.add(new wisata1("Sanghyang Kenit\n", "Cisameng Cipanas, Rajamandala Kulon, Kec. Cipatat, Kab. Bandung Barat, Jawa Barat 40554\n",-6.853137, 107.349844));
        dataList.add(new wisata1("Stone Garden\n", "Gunung Masigit, Citatah, Kec. Cipatat, Kab. Bandung Barat, Jawa Barat 40554\n",-6.828142, 107.434996));
        dataList.add(new wisata1("Sungai Cikahuripan\n", "Cihideung, Kec. Parongpong, Kab. Bandung Barat, Jawa Barat 40559\n",-6.790982, 107.612820));
        dataList.add(new wisata1("Taman Wisata Paku Haji\n", "Jl. Haji Gofur KM. 4 RT 02 RW 10, Pakuhaji, Kec. Ngamprah, Kab. Bandung Barat, Jawa Barat 40552\n",-6.835716, 107.534808));
        dataList.add(new wisata1("Tebing Keraton\n", "Ciburial, Kec. Cimenyan, Kab. Bandung Barat, Jawa Barat 40198\n",-6.834047, 107.663604));
        dataList.add(new wisata1("Waterboom Tirtamulya\n", "Jl. Soemawinata No. 88, Tanimulya, Kec. Ngamprah, Kab. Bandung Barat, Jawa Barat 40552\n",-6.860772, 107.525339));
    }

    @Override
    public void onRsClick(int position) {
        Log.d(TAG,"OnRsClick : is clicked"+position);
        Intent intent = new Intent(ListKabBandung.this, wisata.class);
        intent.putExtra("nama", dataList.get(position).getNama());
        intent.putExtra("alamat", dataList.get(position).getAlamat());
        intent.putExtra("lat", dataList.get(position).getLat());
        intent.putExtra("lng", dataList.get(position).getLng());

        startActivity(intent);
    }
}
