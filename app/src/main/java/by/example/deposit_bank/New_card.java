package by.example.deposit_bank;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class New_card extends Activity {

    DatabaseHelper db;
    EditText e1;
    Button b1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_card);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        db = new DatabaseHelper(this);

        e1 = findViewById(R.id.ID_1);

        b1 = findViewById(R.id.Add_card);

        deleteData();
    }
    public void deleteData() {
        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s1 = e1.getText().toString();
                        Integer deletedRows = db.deleteData(s1);
                        if(deletedRows > 0)
                            Toast.makeText(New_card.this,"Удалено",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(New_card.this,"Не удалено",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
