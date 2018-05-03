package com.example.sauceda.consumo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.core.Usuario;
import com.example.core.events.ErrorEvent;
import com.example.core.events.SignUpEvent;
import com.example.core.managers.UserManager;
import com.squareup.otto.Subscribe;

public class MainActivity extends BaseActivity {

    private EditText edtSex, edtBirthday,edtName, edtEmail, edtPass, edtPassConfirm;
    private Button btnCrearUsuario;
    private Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSex=findViewById(R.id.edtSexo);
        edtBirthday=findViewById(R.id.edtFechaNac);
        edtName=findViewById(R.id.edtNombre);
        edtEmail=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtPassword);
        edtPassConfirm=findViewById(R.id.edtPassworConfirm);
        btnCrearUsuario=findViewById(R.id.btnRegistrar);


        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearUsuario();
            }
        });



    }

    private void crearUsuario() {
        String sex=edtSex.getText().toString();
        String name=edtName.getText().toString();
        String birthday=edtBirthday.getText().toString();
        String email=edtEmail.getText().toString();
        String pass=edtPass.getText().toString();
        String passConfirm=edtPassConfirm.getText().toString();

        usuario =new Usuario();
        usuario.setSex(sex);
        usuario.setBirthday(birthday);
        usuario.setName(name);
        usuario.setEmail(email);
        usuario.setPassword(pass);
        usuario.setPassword_confirmation(passConfirm);

        UserManager.singUp(usuario);

    }

    @Subscribe
    public void singupOk(SignUpEvent event){
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
    }

    public void signupError(ErrorEvent event){
        Toast.makeText(this, "Error"+event.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
