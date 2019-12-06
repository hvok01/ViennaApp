package com.example.viennaapp.ui.home;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
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

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<DuenioEvento> duenioEvento;
    private MisSharedPreferences preferencias;
    private Context context;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<DuenioEvento> getDuenioEventoLiveData(){
        if(duenioEvento==null){
            duenioEvento = new MutableLiveData<>();
        }
        return duenioEvento;
    }

    public void getUsuario() {

        String token = preferencias.getToken(context);

        final Call<DuenioEvento> duenioEventoCall = ApiClient.getMyApiInterface().logeado("Bearer "+token);
        duenioEventoCall.enqueue(new Callback<DuenioEvento>() {
            @Override
            public void onResponse(Call<DuenioEvento> call, Response<DuenioEvento> response) {
                if(response.isSuccessful()){
                    DuenioEvento duenioLogeado=response.body();
                    duenioEvento.postValue(duenioLogeado);
                } else {
                    duenioEvento.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<DuenioEvento> call, Throwable t) {
                duenioEvento.postValue(null);
            }
        });


    }

    public String getToken(Context context) {

        String token = preferencias.getToken(context);

        return token;
    }
}