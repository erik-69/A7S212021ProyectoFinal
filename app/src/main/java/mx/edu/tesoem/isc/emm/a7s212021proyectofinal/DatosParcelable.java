package com.example.proyect0;

import android.os.Parcel;
import android.os.Parcelable;

public class DatosParcelable implements Parcelable {

    String nombre, matricula, correo, promedio;

    public DatosParcelable(String nombre, String matricula, String correo, String promedio){
        this.nombre = nombre;
        this.matricula = matricula;
        this.correo = correo;
        this.promedio = promedio;
    }

    protected DatosParcelable(Parcel in){
        nombre = in.readString();
        matricula = in.readString();
        correo = in.readString();
        promedio = in.readString();
    }

    public static final Creator<DatosParcelable> CREATOR = new Creator<DatosParcelable>() {
        @Override
        public DatosParcelable createFromParcel(Parcel in) {
            return new DatosParcelable(in);
        }

        @Override
        public DatosParcelable[] newArray(int size) {
            return new DatosParcelable[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nombre);
        dest.writeString(matricula);
        dest.writeString(correo);
        dest.writeString(promedio);

    }
}
