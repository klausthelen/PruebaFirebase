package com.example.klaus.pruebafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.klaus.pruebafirebase.Objetos.Carro;
import com.example.klaus.pruebafirebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button bt_carro;
    EditText txtDueno;
    EditText txtMarca;
    EditText txtPuertas;
    EditText txtRuedas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_carro = (Button) findViewById(R.id.boton_carros);
        txtDueno = (EditText)findViewById(R.id.etDueno);
        txtMarca = (EditText)findViewById(R.id.etMarca);
        txtRuedas = (EditText)findViewById(R.id.etRuedas);
        txtPuertas = (EditText)findViewById(R.id.etPuertas);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference pruebaRef = database.getReference(FirebaseReferences.PRUEBA_REFERENCE);

        bt_carro.setOnClickListener(new View.OnClickListener() {
            int numpuertas, numruedas = 0;
            String dueno, marca = "";
            public void onClick(View view) {
                numpuertas = Integer.parseInt(txtPuertas.getText().toString());
                numruedas = Integer.parseInt(txtRuedas.getText().toString());
                dueno = txtDueno.getText().toString();
                marca = txtMarca.getText().toString();
                Carro carro = new Carro(marca,dueno,numpuertas ,numruedas);
                try {
                    pruebaRef.child(FirebaseReferences.CARRO_REFERENCE).push().setValue(carro);
                    Toast.makeText(getApplicationContext(), "Se ingreso el carro a la base de datos" , Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Hubo un error " , Toast.LENGTH_SHORT).show();
                }


            }
        });
        /*
        pruebaRef.child(FirebaseReferences.CARRO_REFERENCE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Carro carro = dataSnapshot.getValue(Carro.class);
                Log.i("CARRO" , carro.getDueno());
                Log.i("CARRO" , dataSnapshot.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */
    }
}
