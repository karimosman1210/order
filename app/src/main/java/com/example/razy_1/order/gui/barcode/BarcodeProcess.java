package com.example.razy_1.order.gui.barcode;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.razy_1.order.R;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;
import static com.example.razy_1.order.utels.StaticMethod.oriantation;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

public class BarcodeProcess extends AppCompatActivity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oriantation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_process);
        checkBarcode();

    }

    public void checkBarcode() {
        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
       String qr = result.getContents();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",qr);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
        mScannerView.stopCamera();
        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showToast(this,getString(R.string.NoBarcodeChecked));
        finish();
    }
}
