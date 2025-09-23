package br.com.jtigik.app_02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnFabricarPessoa;
    private Button btnCriarPessoa;
    private Button btnEditarPessoa;
    private Button btnListarPessoa;
    private Button btnRemoverPessoa;
    private Button btnSair;
    private TextView txtPessoa;
    int contador = 0;
    int eventos = 0;

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.btnFabricarPessoa = findViewById(R.id.btnFabricarPessoa);
        this.btnCriarPessoa = findViewById(R.id.btnCriarPessoa);
        this.btnEditarPessoa = findViewById(R.id.btnEditarPessoa);
        this.btnListarPessoa = findViewById(R.id.btnListarPessoa);
        this.btnRemoverPessoa = findViewById(R.id.btnRemoverPessoa);
        this.btnSair = findViewById(R.id.btnSair);
        this.txtPessoa = findViewById(R.id.txtPessoa);

        btnFabricarPessoa.setOnClickListener(v -> {
            fabricaPessoa();
        });

        btnCriarPessoa.setOnClickListener(v -> {
            criarPessoa();
        });

        btnEditarPessoa.setOnClickListener(v -> {
            editarPessoa();
        });

        btnListarPessoa.setOnClickListener(v -> {
            listarPessoas();
        });

        btnRemoverPessoa.setOnClickListener(v -> {
            removerPessoa();
        });

        btnSair.setOnClickListener(v -> {
            contador++;
            Log.d("eventos", "Buttom 'Sair' clicado "+contador);
            finish();
        });
    }

    private void fabricaPessoa(){
        txtPessoa.setText("Número de pessoas criadas: " + contador);

        int idade = getIdade();
        pessoa = new Pessoa("João", "Silva", idade);
        txtPessoa.setText(pessoa.toString());
    }

    @SuppressLint("SetTextI18n")
    private void criarPessoa(){
        eventos ++;
        contador++;
        fabricaPessoa();
        txtPessoa.setText(pessoa.getNome()+" "+pessoa.getSobrenome()+
                " "+pessoa.getIdade()+" - "+contador+ " - Pessoa(s)");
        Log.e("eventos", "Total eventos: "+eventos + " Criar Pessoa");
        Log.w("eventos", "Total eventos: "+eventos + " Criar Pessoa");
    }

    @SuppressLint("SetTextI18n")
    private void listarPessoas(){
        eventos ++;
        contador++;
        txtPessoa.setText(pessoa.getNome()+ " "+pessoa.getSobrenome()+
                " "+pessoa.getIdade()+" - "+contador+ " - Pessoa(s)");
        Log.i("eventos", "Total eventos: "+eventos + " Listar Pessoa");
    }

    @SuppressLint("SetTextI18n")
    private void editarPessoa(){
        eventos ++;
        contador++;
        txtPessoa.setText(pessoa.getNome()+ " "+pessoa.getSobrenome()+
                " "+pessoa.getIdade()+" - "+contador+ " - Pessoa(s)");
        Log.d("eventos", "Total eventos: "+eventos + " Editar Pessoa");
    }
    @SuppressLint("SetTextI18n")
    private void removerPessoa(){
        eventos ++;
        contador++;
        txtPessoa.setText(pessoa.getNome()+ " "+pessoa.getSobrenome()+
                " "+pessoa.getIdade()+" - "+contador+ " - Pessoa(s)");
        Log.v("eventos", "Total eventos: "+eventos + " Remover Pessoa");

    }

    private static int getIdade(){
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 65;
        return idadeAleatoria.nextInt(max - min + 1) + min;
    }
}