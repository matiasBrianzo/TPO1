package usuario.example.tpo1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;
import java.util.TreeMap;

import usuario.example.tpo1.modelo.DTOPalabra;

public class MainActivityViewModel extends AndroidViewModel
{
    private Context context;
    private List<DTOPalabra> listaPalabra;

    private TreeMap<String,DTOPalabra> diccionario= new TreeMap<>();

    private DTOPalabra Palabra;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

       /* listaPalabra.add(new DTOPalabra("casa","House",R.drawable.casa));
        listaPalabra.add(new DTOPalabra("perro","DOG",R.drawable.perro));
        listaPalabra.add(new DTOPalabra("gato","CAT",R.drawable.gato));
        listaPalabra.add(new DTOPalabra("auto","CARD",R.drawable.auto));
        listaPalabra.add(new DTOPalabra("avion","PLANE",R.drawable.avion));*/

        this.diccionario.put("casa",new DTOPalabra("casa","House",R.drawable.casa));
        this.diccionario.put("perro",new DTOPalabra("perro","DOG",R.drawable.perro));
        this.diccionario.put("gato",new DTOPalabra("gato","CAT",R.drawable.gato));
        this.diccionario.put("auto",new DTOPalabra("auto","CARD",R.drawable.auto));
        this.diccionario.put("avion",new DTOPalabra("PLANE","PLANE",R.drawable.avion));

    }

    public void Traducir(String palabra)
    {
        try {
            if(palabra.length()>0) {
                DTOPalabra dtoPalabra = this.diccionario.get(palabra);
                Log.d("matias", dtoPalabra.getEng());
                if(dtoPalabra != null) {
                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.putExtra("lstpalabra", dtoPalabra);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else {
                    Toast.makeText(context,"Palabra no encontrada", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(context,"Palabra no encontrada", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e) {
           // Toast.makeText(context,e.getMessage(), Toast.LENGTH_LONG).show();

        }

    }
}
