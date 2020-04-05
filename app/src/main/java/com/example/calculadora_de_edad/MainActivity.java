package com.example.calculadora_de_edad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {





    Button Btncalendario;
    TextView Txt_fecha;
    TextView Txt_edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btncalendario =(Button)findViewById(R.id.btncalendar);
        Txt_fecha =(TextView)findViewById(R.id.tex_fecha);
        Txt_edad=(TextView)findViewById(R.id.txt_edad);

        //Boton para ejecutar el  metodo Datos
        Btncalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datos();
            }
        });

    }

    // Decraración del metodo Datos donde se obtener   dia, mes y año de la Clase  Calendar
    private void Datos() {

       Calendar c = Calendar.getInstance();  // intancia del clase  Calendar
       int dia= c.get(Calendar.DAY_OF_MONTH);  // obtener el dia y guardarlo en la variable dia
       int mes= c.get(Calendar.MONTH);    // obtener el mes y guardarlo en la variable mes
       int ano=c.get(Calendar.YEAR);     // obtener el año y guardarlo en la variable ano


        // DatePickerDialog componente a motrar en el XML cuando se le de clic al Btncalendario
        DatePickerDialog datePickerDialog= new DatePickerDialog(MainActivity.this,
        new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Txt_fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year); // Motrar la fecha en el TextView Txt_fecha.

             calcularEdad( dayOfMonth, month,  year);


            }
        },ano,mes,dia);

        datePickerDialog.show();


    }


    //inicio del metodo calcular edad
    private void calcularEdad(int idiaN, int mesN, int anoN) {

        Calendar c = Calendar.getInstance();
        int diaA= c.get(Calendar.DAY_OF_MONTH);
        int mesA= c.get(Calendar.MONTH);
        int anoA=c.get(Calendar.YEAR);

        int edad= anoA - anoN;

        if (mesN>mesA){

            edad--;
        } else  if (mesA==mesN){
                if(diaA>idiaN){
                    edad--;
                }
        }
        Txt_edad.setText("Edad  :"+edad);
    }

//Final del metodo calcular edad

}
