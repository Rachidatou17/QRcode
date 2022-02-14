package com.example.codeqr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class MainActivity extends AppCompatActivity {

    private TextView text;
   private  CodeScanner codeScanner;
   private CodeScannerView codeScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.textView);
       codeScannerView=findViewById(R.id.scannerView);
       codeScanner=new CodeScanner(this,codeScannerView);

       codeScanner.setDecodeCallback(new DecodeCallback() {
           @Override
           public void onDecoded(@NonNull Result result) {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       text.setText(result.getText());
                   }
               });
           }
       });
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestCamera();
    }

    private void requestCamera() {
        codeScanner.startPreview();
    }
}