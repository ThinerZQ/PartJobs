package com.game;

import java.util.ArrayList;


public class Poker {
    public static void main(String[] args) {

        CardDeal cardDeal = new CardDeal();

        if (args.length<5) {
            System.out.println(" wrong number of arguments; must be a multiple of 5");
            System.exit(0);
        } else if (args.length > 5) {
            System.out.println("NOT UNDERTAKEN");
            System.exit(0);
        } else {
            ArrayList<Card> cardArrayList = new ArrayList<>();
            for (String s : args) {
                char[] chars = s.toCharArray();
                cardArrayList.add(cardDeal.getCard(chars));
            }
            cardDeal.getOutPutInfo(cardArrayList);
        }


    }
}
