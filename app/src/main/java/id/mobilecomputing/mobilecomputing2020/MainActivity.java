package id.mobilecomputing.mobilecomputing2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void inputName(View view){
        EditText nameTimA = findViewById(R.id.edt_name_tim_a);
        EditText nameTimB = findViewById(R.id.edt_name_tim_b);

        String getNameTimA = nameTimA.getText().toString();
        String getNameTimB = nameTimB.getText().toString();

        Intent dataName = new Intent(this, CounterActivity.class);
        dataName.putExtra("TIM A", getNameTimA);
        dataName.putExtra("TIM B", getNameTimB);
        startActivity(dataName);
    }
}
