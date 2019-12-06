package com.example.viennaapp.ui.solicitarEvento;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viennaapp.models.Evento;
import com.example.viennaapp.request.ApiClient;
import com.example.viennaapp.request.MisSharedPreferences;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolicitarEventoViewModel extends AndroidViewModel {

    private MutableLiveData<Evento> miEvento;
    private Context context;
    private MisSharedPreferences preferencias;

    public SolicitarEventoViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Evento> getEventoViewModel(){
        if(miEvento==null){
            miEvento = new MutableLiveData<>();
        }
        return miEvento;
    }

    public void enviarSolicitudEvento(String nombreSala, String nombreEvento, String fechaInicio, String fechaFin, String precio) {
        String token = preferencias.getToken(context);

        Call<Evento> eventoCall = ApiClient.getMyApiInterface().solicitarEvento("Bearer "+token,nombreSala,nombreEvento,fechaInicio,fechaFin,precio);
        eventoCall.enqueue(new Callback<Evento>() {
            @Override
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context, "Evento solicitado con exito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Fecha no disponible", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Evento> call, Throwable t) {
                Toast.makeText(context, "Error al completar la solicitud", Toast.LENGTH_SHORT).show();
            }
        });


    }



}