package com.example.viennaapp.ui.verContratos;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viennaapp.models.Contrato;
import com.example.viennaapp.request.ApiClient;
import com.example.viennaapp.request.MisSharedPreferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerContratosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Contrato>> listaContratos;
    private Context context;
    private MisSharedPreferences preferencias;
    private List<Contrato> resultado;

    public VerContratosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<List<Contrato>> getLista(){
        if(listaContratos==null){
            listaContratos = new MutableLiveData<>();
        }
        return listaContratos;
    }

    public void traerContratosByDuenio() {

        String token = preferencias.getToken(context);

        Call<List<Contrato>> listaDeContratosCall = ApiClient.getMyApiInterface().traerContratoByDuenio("Bearer "+token);
        listaDeContratosCall.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {

                if(response.isSuccessful()){

                    List<Contrato> guardar = response.body();

                    List<Contrato> resultado = new ArrayList<>();

                    for (Contrato it: guardar) {

                        resultado.add(it);

                    }

                    listaContratos.postValue(resultado);

                } else {
                    Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                listaContratos.postValue(null);
                Toast.makeText(context, t.getStackTrace()+"", Toast.LENGTH_LONG).show();
                Log.d("error",t.getCause()+"");
            }
        });

    }
}