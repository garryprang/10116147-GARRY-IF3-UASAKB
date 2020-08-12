package com.example.uasAKB_10116147;

import android.os.Parcel;
import android.os.Parcelable;

// Tanggal  Pengerjaan  : 7-11 Agustus 2020
// NIM	            	: 10116147
// Nama                 : Garry Prang
// Kelas	            : IF-3

public class wisata1 implements Parcelable {
    String nama;
    String alamat;
    double lat,lng;
    public wisata1(String nama, String alamat, double lat, double lng) {
        this.nama = nama;
        this.alamat = alamat;
        this.lat = lat;
        this.lng = lng;
    }

    protected wisata1(Parcel in) {
        nama = in.readString();
        alamat = in.readString();
        lat = in.readInt();
        lng = in.readInt();
    }

    public static final Creator<wisata1> CREATOR = new Creator<wisata1>() {
        @Override
        public wisata1 createFromParcel(Parcel in) {
            return new wisata1(in);
        }

        @Override
        public wisata1[] newArray(int size) {
            return new wisata1[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getLat(){
        return lat;
    }
    public double getLng(){
        return lng;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(alamat);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }
}