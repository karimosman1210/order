package com.example.razy_1.order.gui.mainpage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.data.DialogData.DialogListener;
import com.example.razy_1.order.gui.basket.CartFragment;
import com.example.razy_1.order.gui.history.MyOrderFragment;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.gui.login.Login;
import com.example.razy_1.order.gui.profile.ProfileFragment;
import com.example.razy_1.order.utels.DialogPoP;
import com.example.razy_1.order.utels.StaticConfig;
import com.example.razy_1.order.utels.StaticMethod;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import dmax.dialog.SpotsDialog;

import static com.example.razy_1.order.data.shared_pref.ShardPrefKey.App_Name;
import static com.example.razy_1.order.utels.StaticMethod.oriantation;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

public class HomePage extends AppCompatActivity {

    @BindView(R.id.categoryTool)
    Toolbar categoryTool;
    @BindView(R.id.orderCheck)
    ImageView orderCheck;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.homeImageselectCat)
    ImageView homeImageselectCat;
    @BindView(R.id.orderUnselectCat)
    ImageView orderUnselectCat;
    @BindView(R.id.profile_imageCat)
    CircleImageView profileImageCat;
    @BindView(R.id.myCard)
    ImageView myCard;
    @BindView(R.id.logout)
    ImageView logout;
    HomeFragment homeFragment;
    MyOrderFragment myOrderFragment;
    CartFragment cartFragment;
    ProfileFragment profileFragment;
    ShowItemFragment showItemFragment;
    @BindView(R.id.sizeCart)
    TextView sizeCart;
    @BindView(R.id.frameCount)
    public FrameLayout frameCount;
    @BindView(R.id.itemSelectTv)
    TextView itemSelectTv;
    @BindView(R.id.backImge)
    ImageView backImge;
    @BindView(R.id.itemselectLinear)
    LinearLayout itemselectLinear;
    static boolean x = false;
    SpotsDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oriantation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        initFragment();
        changeHomeSelect();
        setCountCard();

    }


    private void setCountCard() {
        if (!StaticConfig.items.isEmpty()) {
            frameCount.setVisibility(View.VISIBLE);
            sizeCart.setText(StaticConfig.items.size() + "");

        } else {
            frameCount.setVisibility(View.GONE);

        }
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        myOrderFragment = new MyOrderFragment();
        cartFragment = new CartFragment();
        profileFragment = new ProfileFragment();
        showItemFragment = new ShowItemFragment();
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @OnClick({R.id.homeImageselectCat, R.id.orderUnselectCat, R.id.profile_imageCat, R.id.myCard, R.id.logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homeImageselectCat:
                changeHomeSelect();
                break;
            case R.id.orderUnselectCat:

                orderSelect();

                break;
            case R.id.profile_imageCat:
                profileSelect();

                break;
            case R.id.myCard:
                if (StaticConfig.items.isEmpty()) {
                    showToast(this, getString(R.string.basketEmpty));
                } else {
                    cartSelect();
                }

                break;
            case R.id.logout:
                new DialogPoP.Builder(this)
                        .setTitle("انتبه !!!!")
                        .setMessage("هل انت متأكد من تسجيل الخروج ؟")
                        .setNegativeBtnText("لا")
                        .setPositiveBtnText("نعم")
                        .isCancellable(true)
                        .OnPositiveClicked(new DialogListener() {
                            @Override
                            public void OnClick() {
                                startActivity(new Intent(HomePage.this, Login.class));
                                finishAffinity();

                                SharedPreferences myPrefs = HomePage.this.getSharedPreferences(App_Name, HomePage.this.MODE_PRIVATE);
                                myPrefs.edit().clear().commit();
                            }
                        })
                        .OnNegativeClicked(new DialogListener() {
                            @Override
                            public void OnClick() {

                            }
                        })
                        .build();

                break;
        }
    }

    private void orderSelect() {
        setFragment(myOrderFragment);
        myCard.setImageResource(R.drawable.shoppingcart_notactive);
        homeImageselectCat.setImageResource(R.drawable.home_notactive);
        orderUnselectCat.setImageResource(R.drawable.myorders_active);
    }

    private void profileSelect() {
        setFragment(profileFragment);
        myCard.setImageResource(R.drawable.shoppingcart_notactive);
        homeImageselectCat.setImageResource(R.drawable.home_notactive);
        orderUnselectCat.setImageResource(R.drawable.myorders_notactive);
    }

    private void cartSelect() {
        setFragment(cartFragment);
        myCard.setImageResource(R.drawable.shoppingcart_active);
        homeImageselectCat.setImageResource(R.drawable.home_notactive);
        orderUnselectCat.setImageResource(R.drawable.myorders_notactive);
    }

    public void changeHomeSelect() {
        setFragment(homeFragment);
        myCard.setImageResource(R.drawable.shoppingcart_notactive);
        homeImageselectCat.setImageResource(R.drawable.home_active);
        orderUnselectCat.setImageResource(R.drawable.myorders_notactive);
    }

    public void changeHome() {
        myCard.setImageResource(R.drawable.shoppingcart_notactive);
        homeImageselectCat.setImageResource(R.drawable.home_notactive);
        orderUnselectCat.setImageResource(R.drawable.myorders_notactive);
    }

    public void inVisableBack() {
        itemselectLinear.setVisibility(View.GONE);
    }

    public void VisableBack() {
        itemselectLinear.setVisibility(View.VISIBLE);
    }

    public void setBack(String nameSelect) {
        itemSelectTv.setText(nameSelect);

    }

    public void backToFragment(final Fragment fragment) {
        getSupportFragmentManager().popBackStackImmediate(
                fragment.getClass().getName(), 0);
    }

    public void setdataCount(int count) {
        sizeCart.setText(String.valueOf(count));
    }

    @Override
    public void onBackPressed() {
        if (homeFragment.isVisible()) {
            new DialogPoP.Builder(this)
                    .setTitle("انتبه !!!!")
                    .setMessage("هل تريد غلق التطبيق ؟")
                    .setNegativeBtnText("لا")
                    .setPositiveBtnBackground("#611F7E")
                    .setPositiveBtnText("نعم")
                    .isCancellable(true)
                    .OnPositiveClicked(new DialogListener() {
                        @Override
                        public void OnClick() {
                            finish();
                        }
                    })
                    .OnNegativeClicked(new DialogListener() {
                        @Override
                        public void OnClick() {

                        }
                    })
                    .build();

        } else {
            backToFragment(homeFragment);
            changeHomeSelect();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 0) {
            if (!StaticConfig.items.isEmpty()) {
                if (StaticConfig.items.size() < 100) {
                    frameCount.setVisibility(View.VISIBLE);
                    sizeCart.setText(StaticConfig.items.size() + "");
                } else {
                    frameCount.setVisibility(View.VISIBLE);
                    sizeCart.setText("+99");
                    x = true;
                }

            } else {
                frameCount.setVisibility(View.GONE);
                x = false;

            }
        }
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                if (result != null) {
                    showToast(this, result);

                }
            }
        }

    }

    @OnClick({R.id.backImge, R.id.itemSelectTv})
    public void onViewClicked() {
        changeHomeSelect();
    }
}
