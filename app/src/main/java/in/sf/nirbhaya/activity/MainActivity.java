package in.sf.nirbhaya.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sf.nirbhaya.R;
import in.sf.nirbhaya.activity.in.sf.nirbhaya.util.SharedPreferenceUtil;
import in.sf.nirbhaya.activity.model.UserModel;

public class MainActivity extends AppCompatActivity {

    RelativeLayout configure;
    TextView tv_configure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        UserModel userModel = SharedPreferenceUtil.getConfiguration(this);
        if ((getIntent() == null && !getIntent().hasExtra("Nirbhay"))) {

            if ((userModel.getUsername() != null || userModel.getPhNum3() != null || userModel.getPhNum1() != null || userModel.getPhNum2() != null || userModel.getEmailId() != null)) {
                startActivity(new Intent(this, NirbhayActivity.class));
                finish();
            }
        }

    }

    private void bindViews() {

        configure = (RelativeLayout) findViewById(R.id.tv_container);
        tv_configure = (TextView) findViewById(R.id.tv_configure);

        configure.setOnClickListener(configureClickListener);

    }

    View.OnClickListener configureClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));

        }
    };
}
