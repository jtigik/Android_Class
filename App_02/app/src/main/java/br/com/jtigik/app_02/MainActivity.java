package br.com.jtigik.app_02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView txtCriarPessoa;
    private TextView txtPessoa;
    private TextView txtIdade;
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

        iniciarComponentesDeLayout();

        btnFabricarPessoa.setOnClickListener(v -> { fabricaPessoa(); });

        btnCriarPessoa.setOnClickListener(v -> { criarPessoa(); });

        btnEditarPessoa.setOnClickListener(v -> { editarPessoa(); });

        btnListarPessoa.setOnClickListener(v -> { listarPessoas(); });

        btnRemoverPessoa.setOnClickListener(v -> { removerPessoa(); });

        btnSair.setOnClickListener(v -> { sairDoApp(); });
    }

    private void iniciarComponentesDeLayout() {
        this.btnFabricarPessoa = findViewById(R.id.btnFabricarPessoa);
        this.btnCriarPessoa = findViewById(R.id.btnCriarPessoa);
        this.btnEditarPessoa = findViewById(R.id.btnEditarPessoa);
        this.btnListarPessoa = findViewById(R.id.btnListarPessoa);
        this.btnRemoverPessoa = findViewById(R.id.btnRemoverPessoa);
        this.btnSair = findViewById(R.id.btnSair);
        this.txtCriarPessoa = findViewById(R.id.txtCriarPessoa);
        this.txtPessoa = findViewById(R.id.txtPessoa);
        this.txtIdade = findViewById(R.id.txtIdade);
    }

    private void sairDoApp() {
        contador++;
        Log.d("eventos", "Buttom 'Sair' clicado "+contador);
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void fabricaPessoa(){
        txtPessoa.setText("Número de pessoas criadas: " + contador);

        int idade = getIdade();
        pessoa = new Pessoa("João", "Silva", idade);
        txtPessoa.setText(pessoa.toString());
    }

    @SuppressLint("SetTextI18n")
    private void criarPessoa(){
        pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setSobrenome("Silva");
        pessoa.setIdade(getIdade());

        txtPessoa.setText(pessoa.toString());
        txtIdade.setText(String.format("Idade da Pessoa: %d", pessoa.getIdade()));
        Toast.makeText(this, "Pessoa Criada", Toast.LENGTH_SHORT).show();

        contador++;
        txtCriarPessoa.setText("Número de pessoas criadas: " + contador);

        Log.d("eventos", "Buttom 'Criar Pessoa' clicado "+contador);
        Log.i("eventos", "Nova Pessoa criada:  "+pessoa.toString());
        Log.w("eventos", "Nome da Pessoa:  "+pessoa.getNome());
        Log.v("eventos", "Idade da Pessoa:  "+pessoa.getIdade());
    }

    @SuppressLint("SetTextI18n")
    private void listarPessoas(){
        /*eventos ++;
        contador++;
        txtPessoa.setText(pessoa.getNome()+ " "+pessoa.getSobrenome()+
                " "+pessoa.getIdade()+" - "+contador+ " - Pessoa(s)");
        Log.i("eventos", "Total eventos: "+eventos + " Listar Pessoa");*/
    }

    @SuppressLint("SetTextI18n")
    private void editarPessoa(){

        if(pessoa != null){
            Toast.makeText(this, String.format("%d Pessoa encontrada", contador), Toast.LENGTH_SHORT).show();
            pessoa.setNome("Maria");
            pessoa.setSobrenome("Silva");
            pessoa.setIdade(getIdade());
            txtPessoa.setText(pessoa.toString());
            txtIdade.setText(String.format("Idade da Pessoa: %d", pessoa.getIdade()));
        }else{
            Toast.makeText(this, "Pessoa não encontrada", Toast.LENGTH_SHORT).show();
            Log.e("eventos", "Pessoa não existe");
        }
    }
    @SuppressLint("SetTextI18n")
    private void removerPessoa(){

        if(pessoa != null){
            Toast.makeText(this, String.format("%d Pessoa encontrada", contador), Toast.LENGTH_SHORT).show();
            pessoa.setNome(null);
            pessoa.setSobrenome(null);
            pessoa.setIdade(0);
            txtPessoa.setText("Nome: - \nSobrenome: -");
            txtIdade.setText("Idade da Pessoa: -");
            Log.i("eventos", "Pessoa removida:  "+pessoa.toString());
        }else{
            Toast.makeText(this, "Pessoa não encontrada", Toast.LENGTH_SHORT).show();
            Log.e("eventos", "Pessoa não existe");
        }
    }

    private static int getIdade(){
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 65;
        return idadeAleatoria.nextInt(max - min + 1) + min;
    }
}