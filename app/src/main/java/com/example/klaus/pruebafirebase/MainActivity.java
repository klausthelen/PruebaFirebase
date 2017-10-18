package com.example.klaus.pruebafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.klaus.pruebafirebase.Objetos.Carro;
import com.example.klaus.pruebafirebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button bt_carro;
    EditText txtPuertas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_carro = (Button) findViewById(R.id.boton_carros);
        txtPuertas = (EditText)findViewById(R.id.etPuertas);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference pruebaRef = database.getReference(FirebaseReferences.PRUEBA_REFERENCE);

        bt_carro.setOnClickListener(new View.OnClickListener() {
            int numpuertas = 0;
            public void onClick(View view) {
                numpuertas = Integer.parseInt(txtPuertas.getText().toString());
                Carro carro = new Carro("Audi","Klaus",numpuertas , 4);
                pruebaRef.child(FirebaseReferences.CARRO_REFERENCE).push().setValue(carro);
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
