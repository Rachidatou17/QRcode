package com.example.codeqr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class QrActivity extends AppCompatActivity {

    private Button Scan;
    String[] permissions = {
            Manifest.permission.CAMERA
    };
    int PERM_CODE = 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        Scan=findViewById(R.id.button);

        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    private boolean checkpermissions(){
        List<String> listofpermissions= new ArrayList<>();
        for (String perm:permissions){
            if(ContextCompat.checkSelfPermission(getApplicationContext(),perm)!= PackageManager.PERMISSION_GRANTED){
                listofpermissions.add(perm);
            }
        }
        if (!listofpermissions.isEmpty()){
            ActivityCompat.requestPermissions(this,listofpermissions.toArray(new String[listofpermissions.size()]),PERM_CODE);
            return false;
        }
        return true;
    }
}