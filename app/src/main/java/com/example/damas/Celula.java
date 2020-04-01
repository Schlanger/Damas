package com.example.damas;

public class Celula
{
    int x;
    int y;

    public Celula (int x,int y) {
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Celula c)
    {
        if(c == null)
            return false;

        return (this.x == c.x && this.y == c.y);
    }
}
