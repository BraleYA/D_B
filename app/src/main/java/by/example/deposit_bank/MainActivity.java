package by.example.deposit_bank;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        db = new DatabaseHelper(this);
        b1 = findViewById(R.id.See);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getAllData();
                if(res.getCount() == 0) {
                    // show message
                    showMessage("Ошибка","Ничего не найдено");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Фамилия :"+ res.getString(2)+"\n");
                    buffer.append("Имя :"+ res.getString(1)+"\n");
                    buffer.append("Отчество :"+ res.getString(3)+"\n");
                    buffer.append("Номер паспорта :"+ res.getString(7)+"\n");
                    buffer.append("Дата рождения :"+ res.getString(9)+"\n");
                    buffer.append("Дата внесения :"+ res.getString(10)+"\n");
                    buffer.append("Дата регистрации :"+ res.getString(11)+"\n");
                    buffer.append("Сумма :"+ res.getString(4)+"\n");
                    buffer.append("Процент :"+ res.getString(5)+"\n");
                    buffer.append("Плюс :"+ res.getString(6)+"\n");
                    buffer.append("Номер телефона :"+ res.getString(8)+"\n\n");
                }

                // Show all data
                showMessage("Клиентская база",buffer.toString());
            }
        });
    }

    public void Plus(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void Update(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void Delete(View view) {
        Intent intent = new Intent(this, New_card.class);
        startActivity(intent);
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
