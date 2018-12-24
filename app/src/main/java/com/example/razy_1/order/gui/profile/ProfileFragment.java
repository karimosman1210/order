package com.example.razy_1.order.gui.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.data.beans.User;
import com.example.razy_1.order.gui.mainpage.HomePage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.razy_1.order.data.shared_pref.ShardPrefUtils.listUserInfo;
import static com.example.razy_1.order.utels.StaticMethod.getListSharedRef;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    @BindView(R.id.changePassLinear)
    LinearLayout changePassLinear;
    @BindView(R.id.imgeProfileEdit)
    CircleImageView imgeProfileEdit;
    @BindView(R.id.infoProfilePerson)
    LinearLayout infoProfilePerson;
    @BindView(R.id.editProfileInfo)
    LinearLayout editProfileInfo;
    @BindView(R.id.chanePassBtn)
    Button chanePassBtn;
    @BindView(R.id.editProfile)
    Button editProfile;
    @BindView(R.id.LinearBtn)
    LinearLayout LinearBtn;
    @BindView(R.id.saveEditProfile)
    Button saveEditProfile;
    @BindView(R.id.savechangePassBtn)
    Button savechangePassBtn;
    Unbinder unbinder;
    @BindView(R.id.nameTv)
    TextView nameTv;
    @BindView(R.id.emailIdTV)
    TextView emailIdTV;
    @BindView(R.id.phoneNumberTv)
    TextView phoneNumberTv;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((HomePage) getActivity()).inVisableBack();
        profileINfoSharedPref();
        return view;
    }

    private void profileINfoSharedPref() {
        List<User> myUser= getListSharedRef(listUserInfo,getActivity());
        nameTv.setText(myUser.get(0).getUsername());
        emailIdTV.setText(myUser.get(0).getEmail());
        phoneNumberTv.setText(myUser.get(0).getPhone());

    }

    @OnClick({R.id.imgeProfileEdit, R.id.infoProfilePerson, R.id.editProfileInfo, R.id.chanePassBtn, R.id.editProfile, R.id.LinearBtn, R.id.saveEditProfile, R.id.savechangePassBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgeProfileEdit:
                break;
            case R.id.infoProfilePerson:
                break;
            case R.id.editProfileInfo:
                break;
            case R.id.chanePassBtn:
                chanePassBtn();
                break;
            case R.id.editProfile:
                editProfile();
                break;
            case R.id.LinearBtn:
                break;
            case R.id.saveEditProfile:
                saveEditProfile();
                break;
            case R.id.savechangePassBtn:
                savechangePassBtn();
                break;
        }
    }

    private void savechangePassBtn() {
        infoProfilePerson.setVisibility(View.VISIBLE);
        changePassLinear.setVisibility(View.GONE);
        savechangePassBtn.setVisibility(View.GONE);
        LinearBtn.setVisibility(View.VISIBLE);
        imgeProfileEdit.setVisibility(View.VISIBLE);
    }

    private void saveEditProfile() {
        infoProfilePerson.setVisibility(View.VISIBLE);
        editProfileInfo.setVisibility(View.GONE);
        LinearBtn.setVisibility(View.VISIBLE);
        saveEditProfile.setVisibility(View.GONE);
    }

    private void editProfile() {
        infoProfilePerson.setVisibility(View.GONE);
        editProfileInfo.setVisibility(View.VISIBLE);
        LinearBtn.setVisibility(View.GONE);
        saveEditProfile.setVisibility(View.VISIBLE);
    }

    private void chanePassBtn() {
        infoProfilePerson.setVisibility(View.GONE);
        changePassLinear.setVisibility(View.VISIBLE);
        editProfileInfo.setVisibility(View.GONE);
        LinearBtn.setVisibility(View.GONE);
        savechangePassBtn.setVisibility(View.VISIBLE);
        saveEditProfile.setVisibility(View.GONE);
        imgeProfileEdit.setVisibility(View.INVISIBLE);
    }


}
