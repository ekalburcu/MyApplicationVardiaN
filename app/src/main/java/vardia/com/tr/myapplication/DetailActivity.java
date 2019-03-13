package vardia.com.tr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView baslikTextv, ilceTextv, tarihTextv, saatTextv, pozisyonTextv, kiyafetTextv,ucretTextv;
    String DBaslik;
    String latitudeString;
    String longitudeString;
    Double latitude;
    Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        baslikTextv = findViewById(R.id.baslik_text_detail_ac);
        ilceTextv = findViewById(R.id.ilce_text_detail_ac);
        tarihTextv = findViewById(R.id.tarih_text_detail_ac);
        saatTextv = findViewById(R.id.saat_text_detail_ac);
        pozisyonTextv = findViewById(R.id.pozisyon_text_detail_ac);
        kiyafetTextv = findViewById(R.id.kiyafet_text_detail_ac);
        ucretTextv = findViewById(R.id.ucret_text_detail_ac);

        Intent intent = getIntent();
        DBaslik = intent.getStringExtra("Baslik");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapDetail);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        getData();

    }

    public void Basvuru (View view){


        BasvurParse();

    }


    public void BasvurParse(){

        ParseUser parseUser = ParseUser.getCurrentUser();

        ParseObject parseObject = new ParseObject("Basvurular");
        parseObject.put("Kullanici_Adi",parseUser.getUsername());
        parseObject.put("Is_Adi",DBaslik);
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){

                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(),"Basvuru Basarili",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


    public void getData(){

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Jobs");
        query.whereEqualTo("Baslik",DBaslik);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (e != null) {

                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                } else {

                    if (objects.size()>0){

                        for (final ParseObject object : objects) {

                            baslikTextv.setText(DBaslik);

                            ilceTextv.setText(object.getString("Ilce"));
                            tarihTextv.setText(object.getString("Tarih"));
                            saatTextv.setText(object.getString("Saat"));
                            pozisyonTextv.setText(object.getString("Pozisyon"));
                            kiyafetTextv.setText(object.getString("Kiyafet"));
                            ucretTextv.setText(object.getString("Ucret"));

                            latitudeString = object.getString("Latitude");
                            longitudeString = object.getString("Longitude");

                            latitude = Double.parseDouble(latitudeString);
                            longitude = Double.parseDouble(longitudeString);

                            mMap.clear();

                            LatLng placeLocation = new LatLng(latitude,longitude);
                            mMap.addMarker(new MarkerOptions().position(placeLocation).title(DBaslik));
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLocation,15));

                        }
                    }
                }
            }
        });


    }
}
