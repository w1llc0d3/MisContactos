package willcode.com.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;

    DatePicker fecha;
    Button btnSig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        nombre        = (EditText) findViewById(R.id.etNombre);
        fecha         = (DatePicker) findViewById(R.id.dpFecha);
        telefono      = (EditText) findViewById(R.id.etTelefono);
        email         = (EditText) findViewById(R.id.etEmail);
        descripcion   = (EditText) findViewById(R.id.etDescripcion);

        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonth()+1;
        int anio = fecha.getYear();

        final String miFecha = dia+"/"+mes+"/"+anio;

        btnSig = (Button) findViewById(R.id.btnSiguiente);

        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra("Nombre", nombre.getText().toString());
                intent.putExtra("Fecha", miFecha.toString());
                intent.putExtra("Telefono", telefono.getText().toString());
                intent.putExtra("Email", email.getText().toString());
                intent.putExtra("Descripcion", descripcion.getText().toString());
                startActivity(intent);
            }
        });
    }
}