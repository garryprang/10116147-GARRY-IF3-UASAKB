package com.example.uasAKB_10116147.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// Tanggal  Pengerjaan  : 7-11 Agustus 2020
// NIM	            	: 10116147
// Nama                 : Garry Prang
// Kelas	            : IF-3

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("JAJALANAN merupakan aplikasi yang menyediakan informasi tempat wisata yang berada di Kota Bandung, Kabupaten Bandung, Kabupaten Bandung Barat, dan Kota Cimahi." + " ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}