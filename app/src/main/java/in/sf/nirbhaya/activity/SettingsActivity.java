package in.sf.nirbhaya.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.sf.nirbhaya.R;
import in.sf.nirbhaya.activity.in.sf.nirbhaya.util.SharedPreferenceUtil;
import in.sf.nirbhaya.activity.model.UserModel;

public class SettingsActivity extends AppCompatActivity {

    EditText et_name, et_phNum1, et_phNum2, et_phNum3, et_email;
    ImageButton btn_phAdd, btn_phDelete1, btn_phDelete2;
    RelativeLayout ph_Num1Container, ph_Num2Container;

    TextView btn_done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.activity_settings);
        bindViews();
        populateUI();
    }


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:

                onBackPressed();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void bindViews() {

        et_name = (EditText) findViewById(R.id.et_userName);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phNum1 = (EditText) findViewById(R.id.et_phNumber1);
        et_phNum2 = (EditText) findViewById(R.id.et_phNumber2);
        et_phNum3 = (EditText) findViewById(R.id.et_phNumber3);

        btn_phAdd = (ImageButton) findViewById(R.id.btn_phAdd);
        btn_phDelete1 = (ImageButton) findViewById(R.id.btn_phDelete1);
        btn_phDelete2 = (ImageButton) findViewById(R.id.btn_phDelete2);

        ph_Num1Container = (RelativeLayout) findViewById(R.id.phNumberContainer2);
        ph_Num2Container = (RelativeLayout) findViewById(R.id.phNumberContainer3);

        btn_done = (TextView) findViewById(R.id.btn_done);

        btn_phAdd.setOnClickListener(showPhNumLayout);

        btn_phDelete1.setOnClickListener(clearPhNum);
        btn_phDelete2.setOnClickListener(clearPhNum);

        btn_done.setOnClickListener(doneButtonClickListener);
    }

    View.OnClickListener showPhNumLayout = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (ph_Num1Container.getVisibility() == View.VISIBLE) {
                ph_Num2Container.setVisibility(View.VISIBLE);
                btn_phAdd.setVisibility(View.GONE);
            } else
                ph_Num1Container.setVisibility(View.VISIBLE);
        }
    };

    View.OnClickListener clearPhNum = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btn_phDelete1:

                    et_phNum2.setText("");
                    ph_Num1Container.setVisibility(View.GONE);
                    break;

                case R.id.btn_phDelete2:

                    et_phNum3.setText("");
                    ph_Num2Container.setVisibility(View.GONE);
                    break;

            }
        }
    };


    View.OnClickListener doneButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            UserModel userModel = saveConfiguration();

            if (userModel.getUsername() != null || userModel.getPhNum3() != null || userModel.getPhNum1() != null || userModel.getPhNum2() != null || userModel.getEmailId() != null) {

                startActivity(new Intent(SettingsActivity.this, NirbhayActivity.class));
                finish();

            }

        }
    };

    @Override
    protected void onPause() {
        saveConfiguration();
        super.onPause();
    }

    private UserModel saveConfiguration() {

        UserModel usermodel = new UserModel(et_name.getText().toString(), et_email.getText().toString(), et_phNum1.getText().toString(), et_phNum2.getText().toString(), et_phNum3.getText().toString());
        SharedPreferenceUtil.saveConfiguration(this, usermodel);
        return usermodel;
    }

    private void populateUI() {

        UserModel userModel = SharedPreferenceUtil.getConfiguration(this);
        et_name.setText(userModel.getUsername());
        et_email.setText(userModel.getEmailId());
        et_phNum1.setText(userModel.getPhNum1());
        if (!userModel.getPhNum2().equalsIgnoreCase("")) {
            ph_Num1Container.setVisibility(View.VISIBLE);
            et_phNum2.setText(userModel.getPhNum2());
        }
        if (!userModel.getPhNum3().equalsIgnoreCase("")) {
            ph_Num2Container.setVisibility(View.VISIBLE);
            et_phNum3.setText(userModel.getPhNum2());
            btn_phAdd.setVisibility(View.GONE);
        }

    }
}
