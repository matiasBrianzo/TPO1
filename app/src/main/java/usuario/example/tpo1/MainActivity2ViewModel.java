package usuario.example.tpo1;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import usuario.example.tpo1.modelo.DTOPalabra;

public class MainActivity2ViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<DTOPalabra> palabraM;
    public MainActivity2ViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public LiveData<DTOPalabra> getPalabraM(){

        if(palabraM==null){

            palabraM=new MutableLiveData<DTOPalabra>();
        }
        return palabraM;
    }

    public void SetPalabraTraducida(DTOPalabra dtoPalabra) {
        if (dtoPalabra.getEng().length()>0) {
            palabraM.setValue(dtoPalabra);
        }

    }
}
