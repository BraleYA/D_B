package by.example.deposit_bank;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHelper db;
    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        db = new DatabaseHelper(this);

        e1 = findViewById(R.id.Name);
        e2 = findViewById(R.id.Last_name);
        e3 = findViewById(R.id.Last_name_1);
        e4 = findViewById(R.id.Money);
        e5 = findViewById(R.id.Persent);
        e6 = findViewById(R.id.Plus_1);
        e7 = findViewById(R.id.Number);
        e8 = findViewById(R.id.Pasport);
        e9 = findViewById(R.id.Born);
        e10 = findViewById(R.id.Register_3);
        e11 = findViewById(R.id.Vneseniya);

        b1 = findViewById(R.id.Register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e5.getText().toString();
                String s6 = e6.getText().toString();
                String s7 = e7.getText().toString();
                String s8 = e8.getText().toString();
                String s9 = e9.getText().toString();
                String s10 = e10.getText().toString();
                String s11 = e11.getText().toString();


                if (s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")
                        ||s6.equals("")||s7.equals("")||s8.equals("")
                        ||s9.equals("")||s10.equals("")||s11.equals("")){
                    Toast.makeText(getApplicationContext(),"Не заполнено", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean insertData = db.insertData(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
                    if(insertData)
                        Toast.makeText(Register.this,"Записано в базу",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Register.this,"Не записано",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
