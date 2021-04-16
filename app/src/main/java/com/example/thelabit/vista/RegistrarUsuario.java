package com.example.thelabit.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.thelabit.R;
import com.example.thelabit.modelo.Corredor;
import com.example.thelabit.modelo.DBTheLabIT;
import com.example.thelabit.modelo.Entrenador;
import com.example.thelabit.modelo.Login;
import com.example.thelabit.vista.entrenador.HomeEntrenador;

public class RegistrarUsuario extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button btnRegistro;
    EditText Rusername, Rpassword, nombre, nacimiento, email ;
    DBTheLabIT DB;
    String[] TipoUsuario = { "Entrenador", "Corredor"};
    String Tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //spinner para seleccionar tipo de usuario
        Spinner spin = findViewById(R.id.spinnerTipoUsuario);
        spin.setOnItemSelectedListener(this);
        spin.setPrompt("Seleccione Tipo de Usuario");

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_spinner_item, TipoUsuario);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);

        btnRegistro     = (Button) findViewById(R.id.btnRegistro);
        Rusername       = (EditText) findViewById(R.id.Rusername);
        Rpassword       = (EditText) findViewById(R.id.Rpassword);
        nombre          = (EditText) findViewById(R.id.nombre);
        nacimiento      = (EditText) findViewById(R.id.nacimiento);
        email           = (EditText) findViewById(R.id.email);
        DB = new DBTheLabIT(this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Capturo los parametros del formulario y dejo null los que no se piden obligatorios
                String PRuser = Rusername.getText().toString();
                String PRpass = Rpassword.getText().toString();
                String Pnombre = nombre.getText().toString();
                String Pnacimiento = nacimiento.getText().toString();  //YYYYMMDD
                String Pciudad = null;
                String Ppais = null;
                String Pemail = email.getText().toString();
                String Pcomentario = null;
                String Pformacion = null;
                String Ppeso = null;
                String Pgenero = null;
                String Paltura = null;
                String Pfcreposo = null;
                String Pfcmaxima = null;
                String Pdistanciaobjetivo = null;
                String Ptiempoestimado = null;




                //Instacia de entrenador y login
                Entrenador entrenador = new Entrenador();
                Corredor corredor = new Corredor ();

                if (Tipo == "Entrenador"){
                    entrenador.setIdUsuario(PRuser);
                    entrenador.setNombre(Pnombre);
                    entrenador.setFechaNacimiento(Pnacimiento);
                    entrenador.setCiudad(Pciudad);
                    entrenador.setPais(Ppais);
                    entrenador.setEmail(Pemail);
                    entrenador.setComentario(Pcomentario);
                    entrenador.setFormacion(Pformacion);
                }else{
                    corredor.setIdUsuario(PRuser);
                    corredor.setNombre(Pnombre);
                    corredor.setFechaNacimiento(Pnacimiento);
                    corredor.setCiudad(Pciudad);
                    corredor.setPais(Ppais);
                    corredor.setEmail(Pemail);
                    corredor.setPeso(Ppeso);
                    corredor.setGenero(Pgenero);
                    corredor.setAltura(Paltura);
                    corredor.setFCReposo(Pfcreposo);
                    corredor.setFCMaxima(Pfcmaxima);
                    corredor.setDistanciaObjetivo(Pdistanciaobjetivo);
                    corredor.setTiempoEstimado(Ptiempoestimado);
                }

                Login login = new Login(PRuser, PRpass);

                Boolean resultado = DB.insertUsuario(Tipo, entrenador, corredor, login);

                if (resultado == true) {
                    Toast.makeText(RegistrarUsuario.this, "exito", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), HomeEntrenador.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(RegistrarUsuario.this, "error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),TipoUsuario[position],Toast.LENGTH_LONG).show();
        Tipo = TipoUsuario[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}