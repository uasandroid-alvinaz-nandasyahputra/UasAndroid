package com.example.loginactivity;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;

// Kelas ini nantinya akan dijadikan service bagi main activity Maps
// untuk meminta lokasi geografis kita.
public class GPS extends Service implements LocationListener {

    private final Context context;
    // untuk status GPS
    boolean isGPSEnabled = false;
    // untuk status jaringan
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    // location
    Location location;
    // mendeklarasikan Location Manager
    protected LocationManager locationManager;

    public GPS(Context context) {
        this.context = context;
    }

    //create a get location method//
    //untuk mendapatkan Lokasi Geografis kita dari GPS.
    public Location getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            //getting GPS status
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            // getting network status
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

// fungsi untk pengecekan apakah GPS sudah dinyalakan atau belum.Jika User belum mengaktifkan GPS kita dapat meminta permisi kepada user untuk mngaktifkan GPS.
            if(ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED ){

                //keakuratan gps (keakuratan rendah)
                if(isGPSEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000,10,this);
                        if(locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }
                    }
                }
                // if location is not found from GPS than it will found from network //
                if(location==null){
                    if(isNetworkEnabled){

                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000,10,this);
                        if(locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }

                    }
                }

            }

        }catch(Exception ex){

        }
        return  location;
    }
    //followings are the default method if we implement locationlistener//
    //dipanggil saat posisi geografis pengguna mengalami perubahan,
    public void onLocationChanged(Location location){

    }
    //dipanggil saat posisi geografis pengguna mengalami perubahan,
    public void onStatusChanged(String Provider, int status, Bundle extras){
    }
    //dipanggil saat provider diaktifkan oleh pengguna,
    public void onProviderEnabled(String Provider){
    }
    //dipanggil saat provider dinon-aktifkan oleh pengguna,
    public void onProviderDisabled(String Provider){
    }
    public IBinder onBind(Intent arg0){
        return null;
    }
}
