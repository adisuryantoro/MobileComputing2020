package id.mobilecomputing.mobilecomputing2020.basketcounter_explisit_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import id.mobilecomputing.mobilecomputing2020.R;
import id.mobilecomputing.mobilecomputing2020.auth_firebase.LoginFirebaseActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_log_out);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

    }

    private void signOut() {
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                goToLoginFirebaseActivity();
            }
        });
    }

    public void inputName(View view) {
        EditText nameTimA = findViewById(R.id.edt_name_tim_a);
        EditText nameTimB = findViewById(R.id.edt_name_tim_b);

        String getNameTimA = nameTimA.getText().toString();
        String getNameTimB = nameTimB.getText().toString();

        Intent dataName = new Intent(this, CounterActivity.class);
        dataName.putExtra("TIM A", getNameTimA);
        dataName.putExtra("TIM B", getNameTimB);
        startActivity(dataName);
    }

    private void goToLoginFirebaseActivity() {
        Intent intent = new Intent(this, LoginFirebaseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
