package com.example.viennaapp.ui.login;


import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.viennaapp.models.DuenioEvento;
import com.example.viennaapp.request.ApiClient;
import com.example.viennaapp.request.MisSharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    private MutableLiveData<String> tokenDuenio;
    private Context miContexto;
    private MisSharedPreferences preferencias;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        miContexto = application.getApplicationContext();
    }

    public LiveData<String> getTokenLiveData(){
        if(tokenDuenio==null){
            tokenDuenio = new MutableLiveData<>();
        }
        return tokenDuenio;
    }

    public void traerToken(String nombre, String clave){

        final Call<String> token = ApiClient.getMyApiInterface().treaerToken(nombre,clave);

        token.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if(response.isSuccessful()){

                    tokenDuenio.setValue(response.body());
                    preferencias.guardarToken(miContexto,tokenDuenio.getValue());

                    final Call<DuenioEvento> duenioEventoCall = ApiClient.getMyApiInterface().logeado("Bearer "+tokenDuenio.getValue());
                    duenioEventoCall.enqueue(new Callback<DuenioEvento>() {
                        @Override
                        public void onResponse(Call<DuenioEvento> call, Response<DuenioEvento> response) {
                            if(response.isSuccessful()){
                                preferencias.guardar(miContexto,response.body());
                            } else {
                                tokenDuenio.postValue(null);
                            }
                        }

                        @Override
                        public void onFailure(Call<DuenioEvento> call, Throwable t) {
                            tokenDuenio.postValue(null);
                        }
                    });



                } else {
                    tokenDuenio.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                tokenDuenio.setValue(null);
            }

        });

    }

        /*try
        {
            Response<String> response = token.execute();
            tokenDuenio.setValue(response.body());

            //API response
            //System.out.println(tokenDuenio);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }*/
}
