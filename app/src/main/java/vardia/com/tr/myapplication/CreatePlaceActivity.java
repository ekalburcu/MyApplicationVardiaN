package vardia.com.tr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreatePlaceActivity extends AppCompatActivity {

    EditText baslikText,ilceText,tarihText,saatText,pozisyonText,kiyafetText,ucretText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_place);

        baslikText = findViewById(R.id.baslik_text_create_place_ac);
        ilceText = findViewById(R.id.ilce_text_create_place_ac);
        tarihText = findViewById(R.id.tarih_text_create_place_ac);
        saatText = findViewById(R.id.saat_text_create_place_ac);
        pozisyonText = findViewById(R.id.pozisyon_text_create_place_ac);
        kiyafetText = findViewById(R.id.kiyafet_text_create_place_ac);
        ucretText = findViewById(R.id.ucret_text_create_place_ac);

    }



    public void next (View view){


        Globals globals = Globals.getInstance();

        String globalBaslik =baslikText.getText().toString();
        String globalIlce = ilceText.getText().toString();
        String globalTarih = tarihText.getText().toString();
        String globalSaat = saatText.getText().toString();
        String globalPozisyon = pozisyonText.getText().toString();
        String globalKiyafet = kiyafetText.getText().toString();
        String globalUcret = ucretText.getText().toString();

        globals.setBaslik(globalBaslik);
        globals.setIlce(globalIlce);
        globals.setTarih(globalTarih);
        globals.setSaat(globalSaat);
        globals.setPozisyon(globalPozisyon);
        globals.setKiyafet(globalKiyafet);
        globals.setUcret(globalUcret);


        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);


    }
}
