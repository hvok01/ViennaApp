package com.example.viennaapp.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.viennaapp.models.DuenioEvento;

public class MisSharedPreferences {

    private static SharedPreferences sp;

    private static SharedPreferences conectar (Context context) {
        if(sp == null) {
            sp = context.getSharedPreferences("datos",0);
        }
        return sp;
    }

    public static void guardar(Context context, DuenioEvento usuario) {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("idDuenioEvento",usuario.getIdDuenioEvento());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("apellido",usuario.getApellido());
        editor.putString("correo",usuario.getCorreo());
        editor.commit();
    }

    public static void guardarToken(Context context, String token) {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token",token);
        editor.commit();
    }

    public static DuenioEvento getDuenioEvento(Context context) {
        SharedPreferences sp = conectar(context);

        int idDuenioEvento = sp.getInt("idDuenioEvento",-1);
        String nombre = sp.getString("nombre","-1");
        String apellido = sp.getString("apellido","-1");
        String correo = sp.getString("correo","-1");
        String clave = " ";
        byte estado = 1;

        DuenioEvento de = new DuenioEvento(idDuenioEvento,nombre,apellido,correo,clave,estado);
        return  de;
    }

    public static String getToken(Context context) {
        SharedPreferences sp = conectar(context);
        String token = sp.getString("token","-1");
        return  token;
    }

    public static void cerrarSesion(Context context){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token","");
        editor.putInt("idDuenioEvento",-1);
        editor.putString("nombre","-1");
        editor.putString("apellido","-1");
        editor.putString("correo","-1");
        editor.commit();
    }

}
