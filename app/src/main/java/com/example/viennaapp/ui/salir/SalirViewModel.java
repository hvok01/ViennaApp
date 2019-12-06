package com.example.viennaapp.ui.salir;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viennaapp.models.Evento;
import com.example.viennaapp.request.MisSharedPreferences;

public class SalirViewModel extends AndroidViewModel {

    private MutableLiveData<String> salida;
    private Context context;
    private MisSharedPreferences preferencias;

    public SalirViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<String> getSalida(){
        if(salida==null){
            salida = new MutableLiveData<>();
        }
        return salida;
    }

    public void salir(){

        preferencias.cerrarSesion(context);

    }



}