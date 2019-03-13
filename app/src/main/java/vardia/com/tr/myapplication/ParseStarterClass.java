package vardia.com.tr.myapplication;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterClass extends Application {

    @Override
    public void onCreate() {


        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("o3rGXQqa29AeTsS0u1QuDZEcto2ykYquyacvb28W")
        .clientKey("3k4MHqFR8yLMTUjHvWr3LmgB13Msg9gCtLGociLj")
        .server("https://parseapi.back4app.com/")
        .build()
        );


        super.onCreate();
    }
}
