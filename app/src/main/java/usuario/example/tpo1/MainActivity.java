package usuario.example.tpo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import usuario.example.tpo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding bindig=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindig.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        bindig.btTraducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.Traducir(bindig.etPalabra.getText().toString());
            }
        });

    }
}