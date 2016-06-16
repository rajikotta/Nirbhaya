package in.sf.nirbhaya.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import in.sf.nirbhaya.R;

/**
 * Created by raji on 5/31/16.
 */
public class NirbhayActivity extends AppCompatActivity {

    ImageView btn_help, btn_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_nirbhay);

        bindViews();
    }

    private void bindViews() {
        btn_help = (ImageView) findViewById(R.id.btn_help);
        btn_settings = (ImageView) findViewById(R.id.btn_settings);
btn_help.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
startActivity(new Intent(NirbhayActivity.this,MainActivity.class));
    }
});
      //  btn_help.setOnClickListener(helpClickListener);
        btn_settings.setOnClickListener(settingsClickListener);

    }

    View.OnClickListener helpClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent=new Intent(NirbhayActivity.this,MainActivity.class);
            intent.putExtra("Nirbhay",true);
            startActivity(intent);
            finish();

        }
    };

    View.OnClickListener settingsClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(NirbhayActivity.this,SettingsActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
