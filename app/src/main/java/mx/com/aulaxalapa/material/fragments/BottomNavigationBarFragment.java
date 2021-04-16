package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class BottomNavigationBarFragment extends Fragment {


    public static final String TAG = "Bottom Navigation";
    private static Component mInstance;

    Unbinder mUnbinder;

    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constantes.STATIC);
        return mInstance;
    }
    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        bottomNavigation.getOrCreateBadge(R.id.action_start);
        //bottomNavigation.removeBadge(R.id.action_start);
        BadgeDrawable favoriteBadge = bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        //Número de caracteres y el +
        favoriteBadge.setMaxCharacterCount(1);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}