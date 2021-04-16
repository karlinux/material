package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class ButtonFragment extends Fragment {

    public static final String TAG = "Button";
    private static Component mInstance;

    Unbinder mUnbinder;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_button);
        mInstance.setType(Constantes.SCROLL);
        return mInstance;
    }
    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnEnable)
    public void onViewClickEnable(){
        Toast.makeText(getActivity(), R.string.status_enabled, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnUnelevateEnable)
    public void onViewClickUnelevateEnable(){
        Toast.makeText(getActivity(), R.string.status_disabled, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}