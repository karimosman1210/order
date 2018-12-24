package com.example.razy_1.order.gui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.utels.ToastUtel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;

import static com.example.razy_1.order.utels.StaticMethod.oriantation;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

public class Login extends AppCompatActivity implements LoginInterface {
    LoginPresenter loginPresenter;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.emailEt)
    EditText emailEt;
    @BindView(R.id.passEt)
    EditText passEt;
    @BindView(R.id.forgetPass)
    TextView forgetPass;
    @BindView(R.id.lognBtn)
    Button lognBtn;
    SpotsDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oriantation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void emptyDialog() {
        showToast(this, getString(R.string.fillData));
        dialog.cancel();
    }

    @Override
    public void sucessLogin() {
        startActivity(new Intent(Login.this, HomePage.class));
        finish();
        dialog.cancel();
    }

    @Override
    public void error() {
        showToast(this, getString(R.string.EmailOrPassError));
        dialog.cancel();
    }

    @Override
    public void noConnection() {
        ToastUtel.COLORTOAST(Login.this,"تأكد من وجود انترنت");
        dialog.cancel();

    }

    @OnClick({R.id.passEt, R.id.lognBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.passEt:
                break;
            case R.id.lognBtn:

                dialog = new SpotsDialog(this, "Loading ......");
                dialog.setCancelable(false);
                dialog.show();
                String email, password;
                email = emailEt.getText().toString().trim();
                password = passEt.getText().toString().trim();
                loginPresenter.checkLogin(email, password, this);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                lognBtn.startAnimation(animation);
                break;
        }

    }


}
