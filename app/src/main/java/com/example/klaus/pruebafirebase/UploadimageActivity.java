package com.example.klaus.pruebafirebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UploadimageActivity extends AppCompatActivity {


    Button bt_subir;
    StorageReference strImagen;
    ImageView imgCarro;
    ProgressDialog mProgress;
    private static final int GALLERY_INTENT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadimage);

        //Para crear storage con firebase
        strImagen = FirebaseStorage.getInstance().getReference();
        bt_subir = (Button) findViewById(R.id.boton_subir);
        imgCarro = (ImageView) findViewById(R.id.iv_imagen);
        bt_subir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, GALLERY_INTENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            //Se crea un uri que es la imagen que se selecciona
            Uri uri = data.getData();

            //Referencia a donde se guardaran las imagenes
            //Crea la carpeta fotos con la imagen seleccionada

            StorageReference filepath = strImagen.child("fotos").child(uri.getLastPathSegment());

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getApplicationContext(), "Se agrego la imagen a el storage " , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
