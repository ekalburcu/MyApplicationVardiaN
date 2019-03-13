package vardia.com.tr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignInActivity extends AppCompatActivity {

    EditText usernameText,passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        usernameText = findViewById(R.id.user_name_signin_ac);
        passwordText = findViewById(R.id.pass_text_signin_ac);

        ParseUser parseUser = ParseUser.getCurrentUser();

        if (parseUser != null){
            Intent intent = new Intent(getApplicationContext(),LocationsActivity.class);
            startActivity(intent);

        }

    }

    public void Giris_yap_Signin (View view){

        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e !=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Hosgeldin: " + user.getUsername(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),LocationsActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}
