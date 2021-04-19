package mx.com.aulaxalapa.material.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.com.aulaxalapa.material.R;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.Constantes;

public class TextFieldFragment extends Fragment {

    public static final String TAG = "Text Fiels";
    private static Component mInstance;

    Unbinder mUnbinder;


    @BindView(R.id.etPrice)
    TextInputEditText etPrice;
    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;
    @BindView(R.id.tilCapitalLayer)
    TextInputLayout tilCapitalLayer;

    public static Component getInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotopRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constantes.SCROLL);
        return mInstance;
    }

    public TextFieldFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_filed, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        tilCapitalLayer.setEndIconOnClickListener(view1 -> {
            if(etCapitalLetter.getText() != null){
                String contentStr = etCapitalLetter.getText().toString();
                etCapitalLetter.setText(contentStr.toUpperCase());
            }
        });

        etPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty() && Integer.valueOf(s.toString()) < 5 ){
                    etPrice.setError(getString(R.string.error_price_min));
                }
            }
        });
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}