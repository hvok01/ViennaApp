package com.example.viennaapp.ui.verEventos;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viennaapp.models.Contrato;
import com.example.viennaapp.models.Evento;
import com.example.viennaapp.request.ApiClient;
import com.example.viennaapp.request.MisSharedPreferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerEventosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Evento>> listaEventos;
    private Context context;
    private MisSharedPreferences preferencias;

    public VerEventosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Evento>> getLista(){
        if(listaEventos==null){
            listaEventos = new MutableLiveData<>();
        }
        return listaEventos;
    }

    public void traerEventosByDuenio() {
        String token = preferencias.getToken(context);

        Call<List<Evento>> listaDeEventosCall = ApiClient.getMyApiInterface().traerEventosByDuenio("Bearer "+token);
        listaDeEventosCall.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                if(response.isSuccessful()){

                    List<Evento> guardar = response.body();

                    List<Evento> resultado = new ArrayList<>();

                    for (Evento it: guardar) {

                        resultado.add(it);

                    }

                    listaEventos.postValue(resultado);
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                    listaEventos.postValue(null);
                    Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cancelarEvento(int id){
        String token = preferencias.getToken(context);

        Call<Evento> eventoCall = ApiClient.getMyApiInterface().cancelarEventoByDuenio("Bearer "+token,id);
        eventoCall.enqueue(new Callback<Evento>() {
            @Override
            public void onResponse(Call<Evento> call, Response<Evento> response) {
                Toast.makeText(context, "Cambios realizados con éxito", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Evento> call, Throwable t) {
                Toast.makeText(context, "Hubo un error procesando la información.", Toast.LENGTH_SHORT).show();
            }
        });

    }

}