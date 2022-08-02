package br.com.unisales.ica1;
//Desenvolvido por :
//Bruno Kobi Valadares de Amorim
//Micheve Neves dos Santos
//Lucas da Silva Borbosa
//Germano Costa Souza
//Marcio Oliveira



import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //opcao do jogador
    String opcao = "";
    //contador vitorias
    int vitoria= 0;
    //verificar se o play está ativado
    boolean ativado=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo para inserir a opção Pedra, como opção do Jogador.
    public void selecionarPedra (View view){
        if(this.ativado==false) {
            ImageView image = findViewById(R.id.imageResultado);
            image.setImageResource(R.drawable.pedra);
            this.opcao = "pedra";
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("");
        }else{
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("APERTE RESTART");
        }
    }
    //Metodo para inserir a opção Papel, como opção do Jogador.
    public void selecionaPapel (View view) {
        if(this.ativado==false) {
            ImageView image = findViewById(R.id.imageResultado);
            image.setImageResource(R.drawable.papel);
            this.opcao = "papel";
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("");
        }else{
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("APERTE RESTART");
        }
        //  this.opcaoSelecionada("papel");
    }

    //Metodo para inserir a opção Tesoura, como opção do Jogador.
    public void selecionaTesoura (View view) {
        if(this.ativado==false) {
            ImageView image = findViewById(R.id.imageResultado);
            image.setImageResource(R.drawable.tesoura);
            this.opcao = "tesoura";
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("");
            // this.opcaoSelecionada("tesoura");
        }else{
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("APERTE RESTART");
        }
    }

    //Metodo para o botão play.
    public void play(View view){
        if(this.ativado==false) {
            if(this.opcao!="" && this.ativado==false) {
                this.opcaoSelecionada(opcao);
            }
            else{
                TextView textResultado = findViewById(R.id.textResultado);
                textResultado.setText("ESCOLHA UMA OPÇÃO !!");
            }
        }
        else{
            TextView textResultado = findViewById(R.id.textResultado);
            textResultado.setText("APERTE RESTART");
        }


    }
    //Metodo para o botão Reset.
    //faz reset das variaveis e imagens
    public void reset(View view){
        ImageView image = findViewById(R.id.imageResultado);
        image.setImageResource(R.drawable.padrao);
        ImageView image2 = findViewById(R.id.imageResultado2);
        image2.setImageResource(R.drawable.padrao);
        TextView textResultado = findViewById(R.id.textResultado);
        textResultado.setText("FAÇA SUA ESCOLHA:");
        this.opcao="";
        this.ativado=false;
        ImageView image3 = findViewById(R.id.textView2);
        image3.setImageResource(R.drawable.maquina);
    }


    @SuppressLint("SetTextI18n")
    //Metodo gera aleatoriamente a opção  do maquina e verifica o ganhador
    public void opcaoSelecionada (String escolhaUsuario) {
        this.ativado=true;
        ImageView image3 = findViewById(R.id.imageResultado3);
        ImageView image = findViewById(R.id.imageResultado2);
        ImageView image2 = findViewById(R.id.textView2);
        TextView textResultado = findViewById(R.id.textResultado);
        TextView vitoria = findViewById(R.id.textResultado2);

        //gerar a opção selecionada pela maquina.
        String [] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];
        //coloca a imagem escolhida pelo robo no image view
        switch (escolhaApp) {
            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                image.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }
        //Logica para Verificar quem é o Ganhador.
        if ((escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))) {
            textResultado.setText("VOCÊ PERDEU !!");
            //chama a imagem do robo venceu
            image2.setImageResource(R.drawable.maquinav);
        }
        else if ((escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))) {
            textResultado.setText("VOCÊ GANHOU !!");
            //Contador de vitorias do jogador.
            this.vitoria++;
            image3.setImageResource(R.drawable.trofeu);
            vitoria.setText(""+this.vitoria);
            //chama a imagem do robo perdeu
            image2.setImageResource(R.drawable.maquinap);
        }
        else {
            textResultado.setText("EMPATOU !!");
        }

    }
}