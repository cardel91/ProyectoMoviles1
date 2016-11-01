package ni.edu.uca.proyectomoviles1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NuevoGrupoActivity extends AppCompatActivity {


    private EditText id, asignatura, estudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_grupo);

        id = (EditText)findViewById(R.id.editText);
        asignatura = (EditText)findViewById(R.id.editText2);
        estudiantes = (EditText)findViewById(R.id.editText3);
        Button buttonOK = (Button) findViewById(R.id.button3);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Grupo grupoNuevo = new Grupo();
                grupoNuevo.setId(Long.valueOf(id.getText().toString()));
                grupoNuevo.setAsignatura(asignatura.getText().toString());
                grupoNuevo.setCantidadEstudiantes(Integer.valueOf(estudiantes.getText().toString()));

                grupoNuevo.save();
                finish();

            }
        });
    }
}
