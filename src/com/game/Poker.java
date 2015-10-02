package com.game;

import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/10/2.
 */
public class Poker {
    public static void main(String[] args) {


        if (args.length == 0) {


        } else if (args.length > 5) {

            System.out.println("NOT UNDERTAKEN");
            System.exit(0);

        } else {

            ArrayList<Card> cardArrayList = new ArrayList<>();
            for (String s : args) {
                char[] chars = s.toCharArray();

                if (chars.length != 2) {
                    System.out.println("error input");
                }
                Card card = new Card();

                switch (chars[0]) {
                    case '2':
                        card.setNumber(Number.two);
                        break;
                    case '3':
                        card.setNumber(Number.three);
                        break;
                    case '4':
                        card.setNumber(Number.four);
                        break;
                    case '5':
                        card.setNumber(Number.five);
                        break;
                    case '6':
                        card.setNumber(Number.six);
                        break;
                    case '7':
                        card.setNumber(Number.seven);
                        break;
                    case '8':
                        card.setNumber(Number.eight);
                        break;
                    case '9':
                        card.setNumber(Number.nine);
                        break;
                    case 'T':
                        card.setNumber(Number.ten);
                        break;
                    case 'J':
                        card.setNumber(Number.eleven);
                    case 'Q':
                        card.setNumber(Number.twelve);
                        break;
                    case 'K':
                        card.setNumber(Number.thirteen);
                        break;
                    case 'A':
                        card.setNumber(Number.ace);
                        break;
                    default:
                        System.out.println("error in number");
                        System.exit(0);
                        break;

                }
                switch (chars[1]){
                    case 'C':
                        card.setType(Type.Clubs);
                        break;
                    case 'H':
                        card.setType(Type.Hearts);
                        break;
                    case 'D':
                        card.setType(Type.Diamonds);
                        break;
                    case 'S':
                        card.setType(Type.Spades);
                        break;
                   default:
                       System.out.println("error in type");
                       System.exit(0);
                       break;

                }

                cardArrayList.add(card);

            }


            CardDeal cardDeal = new CardDeal();

            cardDeal.getOutPutInfo(cardArrayList);

            System.out.println(cardDeal.flush(cardArrayList));
            System.out.println(cardDeal.straight(cardArrayList));



        }


    }
}
