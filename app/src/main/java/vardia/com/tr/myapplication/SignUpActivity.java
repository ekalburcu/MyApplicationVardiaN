package vardia.com.tr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText usernameText,passwordText,emailText,phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        usernameText = findViewById(R.id.user_name_signup_ac);
        passwordText = findViewById(R.id.pass_text_signup_ac);
        emailText = findViewById(R.id.email_signup_ac);
        phoneText = findViewById(R.id.phone_text_signup_ac);
    }



    public void Kayit_ol_Signup (View view){

        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());
        user.setEmail(emailText.getText().toString());
        user.put("phone",phoneText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Kayit Basarili!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
