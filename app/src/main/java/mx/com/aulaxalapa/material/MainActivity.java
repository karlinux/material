package mx.com.aulaxalapa.material;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.aulaxalapa.material.adapters.ComponentAdapter;
import mx.com.aulaxalapa.material.utils.Component;
import mx.com.aulaxalapa.material.utils.OnClickListener;

public class MainActivity extends AppCompatActivity{

    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InicioMaterial.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
