package com.example.kamarou.topquiz.Controleur;

	import android.Manifest;
	import android.content.Context;
	import android.content.Intent;
	import android.content.pm.PackageManager;
	import android.location.Location;
	import android.location.LocationListener;
	import android.support.v4.app.ActivityCompat;
	import android.support.v7.app.AppCompatActivity;
	import android.os.Bundle;
	import android.util.Log;
	import android.view.View;
	import android.widget.Button;
	import android.location.LocationManager;
	import com.example.kamarou.topquiz.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	//Déclaration des buttons 

    private Button mBtnMariage;
    private Button mBtnViSexuel;
    private Button mBtnKidnaping;
    private Button mBtnexcision;
    private Button mBtnVol;
    private Button mBtnTraite;
    private Button mBtnDiscrimination;
    private Button mBtnDescolarisation;
    private Button mBtnAttaque;
    private Button mBtnViolance;
    private int indexReponse;
    private String res;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity::onCreate");
        setTitle("Aceuil");

        //Recuperation of coordonner to geolocalisation

        LocationManager geoloc =
                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        geoloc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Log.d("GPS", "Latitude " + location.getLatitude() + " et longitude " + location.getLongitude());

                res = null;
                PutUtility put = new PutUtility();

                put.setParam("Latitude :", String.valueOf(location.getLatitude()));
                put.setParam("Longitude :", String.valueOf(location.getLongitude()));

               
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

	//Button activation

        mBtnAttaque = (Button) findViewById(R.id.activity_main_btnAttaque);
        mBtnDescolarisation = (Button) findViewById(R.id.activity_main_btnDescolarisation);
        mBtnDiscrimination = (Button) findViewById(R.id.activity_main_btnDiscrimination);
        mBtnViolance = (Button) findViewById(R.id.activity_main_btnVioance);
        mBtnKidnaping = (Button) findViewById(R.id.activity_main_btnKidnapind);
        mBtnexcision = (Button) findViewById(R.id.activity_main_btnExicision);
        mBtnMariage = (Button) findViewById(R.id.activity_main_btnMariagePrecoce);
        mBtnTraite = (Button) findViewById(R.id.activity_main_btnTraite);
        mBtnViSexuel = (Button) findViewById(R.id.activity_main_btnViSexuel);
        mBtnVol = (Button) findViewById(R.id.activity_main_btnVol);

	// configure button to number set for recuper on clic

        mBtnAttaque.setTag(0);
        mBtnDescolarisation.setTag(1);
        mBtnDiscrimination.setTag(2);
        mBtnViolance.setTag(3);
        mBtnKidnaping.setTag(4);
        mBtnexcision.setTag(5);
        mBtnMariage.setTag(6);
        mBtnTraite.setTag(7);
        mBtnViSexuel.setTag(8);
        mBtnVol.setTag(9);

	//activation à button to clicListener

        mBtnAttaque.setOnClickListener(this);
        mBtnDiscrimination.setOnClickListener(this);
        mBtnDescolarisation.setOnClickListener(this);
        mBtnViolance.setOnClickListener(this);
        mBtnKidnaping.setOnClickListener(this);
        mBtnexcision.setOnClickListener(this);
        mBtnMariage.setOnClickListener(this);
        mBtnTraite.setOnClickListener(this);
        mBtnViSexuel.setOnClickListener(this);
        mBtnVol.setOnClickListener(this);
    }

		//action after clic other button

   public void onClick(View v) {
        int indexReponse = (int) v.getTag();

        switch (indexReponse) {
            case 0:{//send to ONG
 		try {
                    res = put.postData("http://2.2.2.221:8000");
                    Log.v("res", res);
                } catch (Exception e) {
                    e.printStackTrace();
                }
	}
            case 1://send to ONG
            case 2://send to POLICE
            case 3://send to ONG
            case 4://send to ONG
            case 5://send to ONG
            case 6://send to ONG
            case 7://send to Police
            case 8://send to ONG
            case 9://send to gendarmerie


        }
    }




    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity::onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity::onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity::onDestroy");
    }
protected void connect(){

}
}