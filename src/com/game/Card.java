package com.game;

/**
 * Created by zhengshouzi on 2015/10/2.
 */
public class Card {

    private Number number;
    private Type type;

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }
}

enum Number {
    two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), eleven(11), twelve(12), thirteen(13), ace(14);

    private int number;

    private Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

enum Type {
    Clubs('C'), Diamonds('D'), Hearts('H'), Spades('S');

    private char type;

    private Type(char type) {
        this.type = type;
    }

}