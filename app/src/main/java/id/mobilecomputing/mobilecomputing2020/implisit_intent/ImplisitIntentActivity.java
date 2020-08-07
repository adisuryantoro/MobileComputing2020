package id.mobilecomputing.mobilecomputing2020.implisit_intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import id.mobilecomputing.mobilecomputing2020.R;

public class ImplisitIntentActivity extends AppCompatActivity {
    private EditText edtDialPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implisit_intent);

        edtDialPhone = findViewById(R.id.edt_dial_phone);

    }

    public void dialPhone(View view){
        Intent intentDialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + edtDialPhone.getText().toString()));
        startActivity(intentDialPhone);
    }

}