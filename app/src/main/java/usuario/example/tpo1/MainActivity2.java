package usuario.example.tpo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import usuario.example.tpo1.databinding.ActivityMain2Binding;
import usuario.example.tpo1.modelo.DTOPalabra;

public class MainActivity2 extends AppCompatActivity {
    private MainActivity2ViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);

        ActivityMain2Binding binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent=getIntent();
        //DTOPalabra dtoPalabra=(DTOPalabra)intent.getSerializableExtra("lstpalabra");
        DTOPalabra dtoPalabra=(DTOPalabra)intent.getSerializableExtra("lstpalabra");

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivity2ViewModel.class);
        mv.getPalabraM().observe(this, new Observer<DTOPalabra>() {
            @Override
            public void onChanged(DTOPalabra dtoPalabra) {
                binding.tvTraducida.setText(dtoPalabra.getEng());
                binding.imageView.setImageResource(dtoPalabra.getFoto());
            }
        });
        mv.SetPalabraTraducida(dtoPalabra);

    }
}