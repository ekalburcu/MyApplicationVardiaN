package vardia.com.tr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void GirisyapMain (View view){

        Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
        startActivity(intent);

    }


    public void KayitolMain (View view){

        Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
        startActivity(intent);

    }

}


