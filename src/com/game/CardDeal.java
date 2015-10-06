package com.game;

import java.util.*;

public class CardDeal {
    public void getOutPutInfo(ArrayList<Card> cardArrayList) {

        Collections.sort(cardArrayList, new CardComparator());

        for (Card card : cardArrayList) {
            System.out.println(card.toString());
        }

        int high =0;
        ArrayList<Integer> tempList = new ArrayList<>();
        int[] tempArray = new int[4];
        if ((high=straightFlush(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println(flag+"-high straight flush");
        } else if ((high=flush(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println(flag+"-high flush");
        }else if ((high=straight(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println(flag+"-high straight");
        }
        else if ((high=highCard(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println(flag+"-high");
        }
        else if ((tempList = twoPair(cardArrayList)).size()==2){
            int temp1 = tempList.get(0);
            int temp2 = tempList.get(1);
            if (temp1>temp2){
                int temp = temp1;
                temp1 = temp2;
                temp2 = temp;
            }
            String highFlag = getFlag(temp2);
            String lowerFlag = getFlag(temp1);
            System.out.println(highFlag+"s over "+lowerFlag+"s");
        }
        else if ((high=threeOfAKind(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println("Three "+flag+"s");
        }
        else if ((high=onePair(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println("Pair of "+flag+"s");
        }  else if ((high=fourOfAkind(cardArrayList)) != 0) {
            String flag =getFlag(high);
            System.out.println("Four "+flag+"s");
        }else if ((tempArray=fullHouse(cardArrayList)).length !=0){
            int three = tempArray[3];
            int two = tempArray[2];

            String threeFlag = getFlag(three);
            String twoFlag = getFlag(two);
            System.out.println(threeFlag+"s full of "+twoFlag+"s");
        }


    }
    public String getFlag(int high){
        String flag="";
        if (high ==10){
            flag="Ten";
        }else if (high==11){
            flag = "Jack";
        }
        else if (high==12){
            flag = "Queen";
        }
        else if (high==13){
            flag = "Jack";
        }
        else if (high==14){
            flag = "Ace";
        }else{
            flag = high+"";
        }
        return  flag;
    }

    //同花顺
    public int straightFlush(ArrayList<Card> cardArrayList) {

        //return flush(cardArrayList)&& straight(cardArrayList);
        int high = 0;
        if (flush(cardArrayList) != 0 && (high = straight(cardArrayList)) != 0) {
            return high;
        }
        return 0;
    }

    //四张
    public int fourOfAkind(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();

        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        if (map.size() == 2) {
            for (Map.Entry<Number, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 4) {
                    return entry.getKey().getNumber();
                }
            }
        }
        return 0;
    }

    //三带一对
    public int[] fullHouse(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();
        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        int[] returns = new int[4];
        if (map.size() == 2) {
            for (Map.Entry<Number, Integer> entry : map.entrySet()) {

                if (entry.getValue() == 3) {
                    returns[3] = entry.getKey().getNumber();
                } else if (entry.getValue() == 2) {
                    returns[2] = entry.getKey().getNumber();
                }

            }
        }
        return returns;
    }

    //三张不带队
    public int threeOfAKind(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();
        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        if (map.size() == 3) {
            for (Map.Entry<Number, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 3) {
                    return entry.getKey().getNumber();
                }
            }
        }
        return 0;
    }

    //两对
    public ArrayList<Integer> twoPair(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();
        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (map.size() == 3) {
            for (Map.Entry<Number, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    arrayList.add(entry.getKey().getNumber());
                }
            }
        }
        return arrayList;
    }

    //一对
    public int onePair(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();
        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        if (map.size() == 4) {
            for (Map.Entry<Number, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    return entry.getKey().getNumber();
                }
            }
        }
        return 0;
    }

    //单张
    public int highCard(ArrayList<Card> cardArrayList) {
        Map<Number, Integer> map = new HashMap<>();
        for (Card card : cardArrayList) {
            map.put(card.getNumber(), map.get(card.getNumber()) == null ? 1 : map.get(card.getNumber()) + 1);
        }
        if (map.size() == 5) {
            return cardArrayList.get(4).getNumber().getNumber();
        }

        return 0;
    }

    //同花
    public int flush(ArrayList<Card> cardArrayList) {
        Set<Type> typeSet = new HashSet<>();
        for (Card card : cardArrayList) {
            typeSet.add(card.getType());
        }
        if (typeSet.size() == 1) {
            return cardArrayList.get(4).getNumber().getNumber();
        }
        return 0;
    }

    //顺子
    public int straight(ArrayList<Card> cardArrayList) {
        if (cardArrayList.get(4).getNumber().getNumber() == cardArrayList.get(0).getNumber().getNumber() + 4) {
            return cardArrayList.get(4).getNumber().getNumber();
        }
        return 0;
    }


    //得到卡片
    public Card getCard(char[] chars){

        StringBuilder sb = new StringBuilder();
        Card card = new Card();

        for (int k=0;k<chars.length;k++){
            sb.append(chars[k]);
        }
        if (chars.length != 2) {
            System.out.println(" invalid card name "+"\'"+sb.toString()+"\'");
            System.exit(0);
        }

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
            case 't':
                card.setNumber(Number.ten);
                break;
            case 'J':
                card.setNumber(Number.eleven);
                break;
            case 'j':
                card.setNumber(Number.eleven);
                break;
            case 'Q':
                card.setNumber(Number.twelve);
                break;
            case 'q':
                card.setNumber(Number.twelve);
                break;
            case 'K':
                card.setNumber(Number.thirteen);
                break;
            case 'k':
                card.setNumber(Number.thirteen);
                break;
            case 'A':
                card.setNumber(Number.ace);
                break;
            case 'a':
                card.setNumber(Number.ace);
                break;
            default:
                System.out.println(" invalid card name "+"\'"+sb.toString()+"\'");
                System.exit(0);
                break;
        }
        switch (chars[1]) {
            case 'C':
                card.setType(Type.Clubs);
                break;
            case 'c':
                card.setType(Type.Clubs);
                break;
            case 'H':
                card.setType(Type.Hearts);
                break;
            case 'h':
                card.setType(Type.Hearts);
                break;
            case 'D':
                card.setType(Type.Diamonds);
                break;
            case 'd':
                card.setType(Type.Diamonds);
                break;
            case 'S':
                card.setType(Type.Spades);
                break;
            case 's':
                card.setType(Type.Spades);
                break;
            default:
                System.out.println(" invalid card name "+"\'"+sb.toString()+"\'");
                System.exit(0);
                break;
        }
        return card;
    }

    private class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            return card1.getNumber().getNumber() - card2.getNumber().getNumber();
        }
    }


}
