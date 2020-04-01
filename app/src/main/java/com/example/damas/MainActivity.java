package com.example.damas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

    //Tabuleiro
    TabuleiroDamas tabuleiro;

    //Butoes
    ImageButton Btn2, Btn4, Btn6, Btn8;//linha1
    ImageButton Btn9, Btn11, Btn13, Btn15;//linha2
    ImageButton Btn18, Btn20, Btn22, Btn24;//linha3
    ImageButton Btn25, Btn27, Btn29, Btn31;//linha4
    ImageButton Btn34, Btn36, Btn38, Btn40;//linha5
    ImageButton Btn41, Btn43, Btn45, Btn47;//linha6
    ImageButton Btn50, Btn52, Btn54, Btn56;//linha7
    ImageButton Btn57, Btn59, Btn61, Btn63;//linha8
    Map<Integer,ImageButton> PosicaoButoes;
    Button BtnNewGame;

    //Text View
    TextView TvPlacar;

    //Controle da partida
    boolean selecionado;
    int posicaoSelecionado;
    int vitoriasBrancos, vitoriasPretos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializaçao do jogo
        tabuleiro = new TabuleiroDamas();
        selecionado = false;
        vitoriasBrancos = 0;
        vitoriasPretos = 0;
        DeclaraButoes();
        MapeamentoButoes();
        AtualizaDadosPlacar();

    }


    private void AtualizaTabuleiro()
    {
        for(int i=1; i<=tabuleiro.GetTamanhoTabuleiro(); i++)
        {
            if(PosicaoButoes.containsKey(i))
            {
                if (tabuleiro.getDominioOcupado(i) == TabuleiroDamas.Dominio.Branco)
                    (PosicaoButoes.get(i)).setImageResource(R.drawable.peao_branco);
                else if (tabuleiro.getDominioOcupado(i) == TabuleiroDamas.Dominio.BrancoDama)
                    (PosicaoButoes.get(i)).setImageResource(R.drawable.dama_branco);
                else if (tabuleiro.getDominioOcupado(i) == TabuleiroDamas.Dominio.Preto)
                    (PosicaoButoes.get(i)).setImageResource(R.drawable.peao_preto);
                else if (tabuleiro.getDominioOcupado(i) == TabuleiroDamas.Dominio.PretoDama)
                    (PosicaoButoes.get(i)).setImageResource(R.drawable.dama_preto);
                else if(tabuleiro.getDominioOcupado(i) == TabuleiroDamas.Dominio.Vazio)
                    (PosicaoButoes.get(i)).setImageResource(R.drawable.textura_escuro);

                //if((PosicaoButoes.get(i)).get)
            }
        }
    }

    private void MarcaPossiveis()
    {

    }

    private void AtualizaPainelResultados()
    {
        if (tabuleiro.Vencedor() == 1)
            vitoriasBrancos ++;
        else
            vitoriasPretos ++;

        AtualizaDadosPlacar();
    }

    private void DeclaraButoes()
    {
        //btn2
        Btn2 = findViewById(R.id.btn2);
        Btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(2);
            }
        });

        //btn4
        Btn4 = findViewById(R.id.btn4);
        Btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               AcaoTabuleiro(4);
            }
        });

        //btn6
        Btn6 = findViewById(R.id.btn6);
        Btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(6);
            }
        });

        //btn8
        Btn8 = findViewById(R.id.btn8);
        Btn8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(8);

            }
        });

        //btn9
        Btn9 = findViewById(R.id.btn9);
        Btn9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(9);

            }
        });

        //btn11
        Btn11 = findViewById(R.id.btn11);
        Btn11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(11);

            }
        });

        //btn13
        Btn13 = findViewById(R.id.btn13);
        Btn13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(13);

            }
        });

        //btn15
        Btn15 = findViewById(R.id.btn15);
        Btn15.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(15);

            }
        });

        //btn18
        Btn18 = findViewById(R.id.btn18);
        Btn18.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(18);

            }
        });

        //btn20
        Btn20 = findViewById(R.id.btn20);
        Btn20.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(20);

            }
        });

        //btn22
        Btn22 = findViewById(R.id.btn22);
        Btn22.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(22);

            }
        });

        //btn24
        Btn24 = findViewById(R.id.btn24);
        Btn24.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(24);

            }
        });

        //btn25
        Btn25 = findViewById(R.id.btn25);
        Btn25.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(25);

            }
        });

        //btn27
        Btn27 = findViewById(R.id.btn27);
        Btn27.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(27);

            }
        });

        //btn29
        Btn29 = findViewById(R.id.btn29);
        Btn29.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(29);

            }
        });

        //btn31
        Btn31 = findViewById(R.id.btn31);
        Btn31.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(31);

            }
        });

        //btn34
        Btn34 = findViewById(R.id.btn34);
        Btn34.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(34);

            }
        });

        //btn36
        Btn36 = findViewById(R.id.btn36);
        Btn36.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(36);

            }
        });

        //btn38
        Btn38 = findViewById(R.id.btn38);
        Btn38.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(38);

            }
        });

        //btn40
        Btn40 = findViewById(R.id.btn40);
        Btn40.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(40);

            }
        });

        //btn41
        Btn41 = findViewById(R.id.btn41);
        Btn41.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(41);

            }
        });

        //btn43
        Btn43 = findViewById(R.id.btn43);
        Btn43.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(43);

            }
        });

        //btn45
        Btn45 = findViewById(R.id.btn45);
        Btn45.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(45);

            }
        });

        //btn47
        Btn47 = findViewById(R.id.btn47);
        Btn47.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(47);

            }
        });

        //btn50
        Btn50 = findViewById(R.id.btn50);
        Btn50.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(50);

            }
        });

        //btn52
        Btn52 = findViewById(R.id.btn52);
        Btn52.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(52);

            }
        });

        //btn54
        Btn54 = findViewById(R.id.btn54);
        Btn54.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(54);

            }
        });

        //btn56
        Btn56 = findViewById(R.id.btn56);
        Btn56.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(56);

            }
        });

        //btn57
        Btn57 = findViewById(R.id.btn57);
        Btn57.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(57);

            }
        });

        //btn59
        Btn59 = findViewById(R.id.btn59);
        Btn59.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(59);

            }
        });

        //btn61
        Btn61 = findViewById(R.id.btn61);
        Btn61.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(61);

            }
        });

        //btn63
        Btn63 = findViewById(R.id.btn63);
        Btn63.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AcaoTabuleiro(63);

            }
        });

        //Nova Partida
        BtnNewGame = findViewById(R.id.btnNewGame);
        BtnNewGame .setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                tabuleiro.NewGame();
                AtualizaTabuleiro();
                selecionado = false;
            }
        });
    }

    private void MapeamentoButoes()
    {
        if(PosicaoButoes == null)
            PosicaoButoes = new HashMap<Integer,ImageButton>();

        PosicaoButoes.clear();

        PosicaoButoes.put(2,Btn2);
        PosicaoButoes.put(4,Btn4);
        PosicaoButoes.put(6,Btn6);
        PosicaoButoes.put(8,Btn8);
        PosicaoButoes.put(9,Btn9);
        PosicaoButoes.put(11,Btn11);
        PosicaoButoes.put(13,Btn13);
        PosicaoButoes.put(15,Btn15);
        PosicaoButoes.put(18,Btn18);
        PosicaoButoes.put(20,Btn20);
        PosicaoButoes.put(22,Btn22);
        PosicaoButoes.put(24,Btn24);
        PosicaoButoes.put(25,Btn25);
        PosicaoButoes.put(27,Btn27);
        PosicaoButoes.put(29,Btn29);
        PosicaoButoes.put(31,Btn31);
        PosicaoButoes.put(34,Btn34);
        PosicaoButoes.put(36,Btn36);
        PosicaoButoes.put(38,Btn38);
        PosicaoButoes.put(40,Btn40);
        PosicaoButoes.put(41,Btn41);
        PosicaoButoes.put(43,Btn43);
        PosicaoButoes.put(45,Btn45);
        PosicaoButoes.put(47,Btn47);
        PosicaoButoes.put(50,Btn50);
        PosicaoButoes.put(52,Btn52);
        PosicaoButoes.put(54,Btn54);
        PosicaoButoes.put(56,Btn56);
        PosicaoButoes.put(57,Btn57);
        PosicaoButoes.put(59,Btn59);
        PosicaoButoes.put(61,Btn61);
        PosicaoButoes.put(63,Btn63);
    }

    private void AcaoTabuleiro(int i)
    {
        if(!tabuleiro.getVez() && (tabuleiro.getDominioOcupado(posicaoSelecionado)== TabuleiroDamas.Dominio.Branco
                ||tabuleiro.getDominioOcupado(posicaoSelecionado)== TabuleiroDamas.Dominio.BrancoDama))
            return;

        if(selecionado)
        {
            boolean consulta = tabuleiro.MovimentoPeca(posicaoSelecionado, i);

            if(consulta)
                AtualizaTabuleiro();
            else
                Toast.makeText(getApplicationContext(),
                        "Comando Inválido.", Toast.LENGTH_SHORT).show();

            if (tabuleiro.Vencedor() != 0)
            {
                AtualizaPainelResultados();
                tabuleiro.NewGame();
            }

            selecionado = false;
        }
        else
        {
            MarcaPossiveis();
            posicaoSelecionado = i;
            selecionado = true;
        }

    }

    private void AtualizaDadosPlacar()
    {
        if(TvPlacar == null)
            TvPlacar = findViewById(R.id.tvPlacar);

        if(tabuleiro.Vencedor()==1)
            Toast.makeText(getApplicationContext(),
                    "Peças Brancas Ganharam!!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),
                    "Peças Pretas Ganharam!!", Toast.LENGTH_SHORT).show();

        TvPlacar.setText("Brancos " + vitoriasBrancos + " x " + vitoriasPretos + " Pretos");
    }
}
