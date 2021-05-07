package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class FloatingActionButtonFragment extends Fragment {

    public static final String TAG = "Floating Action Button";
    private static Component mInstance;


    @BindView(R.id.tvLegacy)
    TextView tvLegacy;

    @BindView(R.id.fabDefault)
    FloatingActionButton fabDefault;
    @BindView(R.id.fabLegacy)
    FloatingActionButton fabLegacy;
    @BindView(R.id.containerMain)
    ConstraintLayout container;

    Unbinder mUnbinder;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_fab_default);
        mInstance.setType(Constantes.STATIC);
        return mInstance;
    }

    public FloatingActionButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floating_action_button, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        fabDefault.setOnClickListener(view1 -> Toast.makeText(getActivity(), R.string.message_action_success,
                Toast.LENGTH_SHORT).show());
        fabLegacy.setOnClickListener(view1 -> {
            fabLegacy.setVisibility(View.GONE);
            tvLegacy.setVisibility(View.GONE);
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}