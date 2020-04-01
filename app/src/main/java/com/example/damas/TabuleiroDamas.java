package com.example.damas;

import java.util.Map;
import java.util.HashMap;

public class TabuleiroDamas
{
    public enum Dominio
    {
        Branco, BrancoDama, Preto, PretoDama, Vazio, Bloqueado
    }

    static int linha = 8;
    static int coluna = 8;
    static int linhaOcupacao = 3; //linhas ocupadas por cada no inicio
    boolean vez;
    TabuleiroDamas controleAnterior;

    //Tabuleiro físico
    Dominio tabuleiro[][];
    Map<Integer,Celula> AtalhoPosicao;
    int numEspacos;
    int numPretos;
    int numBrancos;

    public TabuleiroDamas()
    {
        NewGame();
    }


    public void NewGame()
    {
        AtalhoPosicao = new HashMap<Integer, Celula>();
        InicializaTabuleiro();
        controleAnterior = null;
        vez = true;// Brancos começam
    }

    public boolean getVez()
    {
        return vez;
    }

    public int GetTamanhoTabuleiro()
    {
        return linha*coluna;
    }

    public int Vencedor()
    {
        if(numBrancos == 0)
            return -1;
        else if(numPretos == 0)
            return 1;
        else
            return 0;
    }

    public Dominio getDominioOcupado(Celula cel)
    {
        if(cel.x > linha || cel.y > coluna ||cel.x < 0 || cel.y < 0)
            return null;

        return tabuleiro[cel.x][cel.y];
    }

    public Dominio getDominioOcupado(Integer pos)
    {
        if(!AtalhoPosicao.containsKey(pos))
            return null;

        return getDominioOcupado(AtalhoPosicao.get(pos));
    }

    public boolean EspacoLivre(Celula cel)
    {
        if(tabuleiro[cel.x][cel.y] == Dominio.Vazio)
            return true;
        else
            return false;
    }

    public boolean EspacoLivre(Integer pos)
    {
        if(!AtalhoPosicao.containsKey(pos))
            return false;

        return EspacoLivre(AtalhoPosicao.get(pos));
    }

    public boolean MovimentoPeca(Celula inicio, Celula fim)
    {
        if (inicio.equals(fim))
            return false;

        if (tabuleiro[inicio.x][inicio.y] == tabuleiro[fim.x][fim.y])
            return false;

        if (tabuleiro[fim.x][fim.y] == Dominio.Bloqueado)
            return false;

        boolean comeuPeca = false;
        Dominio peca = tabuleiro[inicio.x][inicio.y];
        Dominio pecaAux = null;//So existe se dor damão a peça para auxilio
        controleAnterior = this;

        if((peca == Dominio.Branco && !vez)||(peca == Dominio.Preto && vez))
            return false;

        if (peca == Dominio.BrancoDama)
            pecaAux = Dominio.Branco;
        else if (peca == Dominio.PretoDama)
            pecaAux = Dominio.Preto;

        if (tabuleiro[fim.x][fim.y] == Dominio.Vazio)
        {
            int difi = fim.x - inicio.x, difj = fim.y - inicio.y;
            int orientacaoi, orientacaoj;

            if (difi > 0)
                orientacaoi = 1;
            else
                orientacaoi = -1;

            if (difj > 0)
                orientacaoj = 1;
            else
                orientacaoj = -1;

            if ((peca == Dominio.Branco && difi > 0) || (peca == Dominio.PretoDama && difi < 0))
                return false;

            if (difi * orientacaoi > 1 || difj * orientacaoj > 1)
            {
                if (peca == Dominio.BrancoDama || peca == Dominio.PretoDama) {
                    for (int i = 1; i < difi * orientacaoi; i++)
                        for (int j = 1; j < difj * orientacaoj; j++) {
                            if (tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] != Dominio.Bloqueado
                                    && difi * orientacaoi == difj * orientacaoj)
                            {
                                if (tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] == peca
                                        || tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] == pecaAux)
                                {
                                    return false;

                                } else if (tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] != Dominio.Vazio) {
                                    if (tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] == Dominio.Branco
                                            || tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] == Dominio.BrancoDama)
                                        numBrancos--;
                                    else
                                        numPretos--;

                                    if(!comeuPeca)
                                        comeuPeca = true;

                                    tabuleiro[inicio.x + i * orientacaoi][inicio.y + j * orientacaoj] = Dominio.Vazio;
                                }
                            }
                        }

                } else {
                    if (difi > 2 || difj > 2 || difi < -2 || difj < -2)
                        return false;

                    if (tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] == peca)
                        return false;

                    else if (tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] != Dominio.Vazio)
                    {

                        if ((tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] == Dominio.Branco
                                || tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] == Dominio.BrancoDama)
                            && peca!=Dominio.Branco)
                            numBrancos--;
                        else if((tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] == Dominio.Preto
                                || tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] == Dominio.PretoDama)
                                && peca!=Dominio.Preto)
                            numPretos--;
                        else
                            return false;

                        comeuPeca = true;
                        tabuleiro[inicio.x + difi - 1 * orientacaoi][inicio.y + difj - 1 * orientacaoj] = Dominio.Vazio;
                    } else
                        return false;
                }

            }

            if (fim.x == linha - 1 && peca == Dominio.Preto)
                peca = Dominio.PretoDama;
            else if (fim.x == 0 && peca == Dominio.Branco)
                peca = Dominio.BrancoDama;

            tabuleiro[inicio.x][inicio.y] = Dominio.Vazio;
            tabuleiro[fim.x][fim.y] = peca;

            TrocaVez(comeuPeca);

            return true;
        }
        else
            return false;
    }

    public boolean MovimentoPeca(Integer inicio, Integer fim)
    {
        if(!AtalhoPosicao.containsKey(inicio) || !AtalhoPosicao.containsKey(fim))
            return false;

        return MovimentoPeca(AtalhoPosicao.get(inicio), AtalhoPosicao.get(fim));
    }

    private void InicializaTabuleiro()
    {
        this.tabuleiro = new Dominio[linha][coluna];
        this.AtalhoPosicao.clear();

        int count = 1;

        numPretos = 0;
        numBrancos = 0;

        for(int i = 0; i < linha; i++)
            for(int j = 0; j < coluna; j++)
            {
                AtalhoPosicao.put(count, new Celula(i,j));
                count ++;
            }

        numEspacos = count -1;

        for(int i = 0; i < linha; i++)
        {
            if(i<linhaOcupacao)
            {
                if(i%2 == 0)
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 == 0) ? Dominio.Bloqueado : Dominio.Preto;
                        numPretos ++;
                    }
                }
                else
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 != 0) ? Dominio.Bloqueado : Dominio.Preto;
                        numPretos ++;
                    }
                }
            }
            else if(i < linha - linhaOcupacao)
            {
                if(i%2 == 0)
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 == 0) ? Dominio.Bloqueado : Dominio.Vazio;
                    }
                }
                else
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 != 0) ? Dominio.Bloqueado : Dominio.Vazio;
                    }
                }
            }
            else
            {
                if(i%2 == 0)
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 == 0) ? Dominio.Bloqueado : Dominio.Branco;
                        numBrancos ++;
                    }
                }
                else
                {
                    for(int j = 0; j < coluna; j++)
                    {
                        tabuleiro[i][j] = (j%2 != 0) ? Dominio.Bloqueado : Dominio.Branco;
                        numBrancos ++;
                    }
                }
            }
        }
    }

    private void TrocaVez(boolean comeuPeca)
    {
        if(!comeuPeca)
            vez = !(vez);
    }
}
