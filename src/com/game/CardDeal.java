package com.game;

import java.util.*;

/**
 * Created by zhengshouzi on 2015/10/2.
 */
public class CardDeal {
    public void getOutPutInfo(ArrayList<Card> cardArrayList) {

        //Card[] cards = (Card[]) cardArrayList.toArray();
       /* for (int i=0;i<cards.length;i++) {

            for (int j=0;j<cards.length;j++){

            }
        }*/

        Collections.sort(cardArrayList, new CardComparator());

        for (Card card  : cardArrayList){
            System.out.println(card.toString());
        }
        //System.out.println(judgeSequence(cardArrayList));


    }

    //同花顺
    public boolean StraightFlush(ArrayList<Card> cardArrayList){

        //return flush(cardArrayList)&& straight(cardArrayList);
        return false;
    }
    //四张
    public boolean fourOfAkind(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();

        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==2){
            for (Map.Entry<Number,Integer> entry :map.entrySet()){
                if (entry.getValue() ==4){
                    return true;
                }
            }
        }
        return false;
    }
    //三带一对
    public boolean fullHouse(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();
        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==2){
            for (Map.Entry<Number,Integer> entry :map.entrySet()){
                if (entry.getValue() ==3){
                    return true;
                }
            }
        }
        return false;
    }
    //三张不带队
    public  boolean threeOfAKind(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();
        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==3){
            for (Map.Entry<Number,Integer> entry :map.entrySet()){
                if (entry.getValue() ==3){
                    return true;
                }
            }
        }
        return false;
    }
    //两对
    public  boolean twoPair(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();
        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==3){
            for (Map.Entry<Number,Integer> entry :map.entrySet()){
                if (entry.getValue() ==2){
                    return true;
                }
            }
        }
        return false;
    }
    //一对
    public  boolean onePair(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();
        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==4){
            for (Map.Entry<Number,Integer> entry :map.entrySet()){
                if (entry.getValue() ==2){
                    return true;
                }
            }
        }
        return false;
    }
    //单张
    public  int highCard(ArrayList<Card> cardArrayList){
        Map<Number,Integer> map = new HashMap<>();
        for(Card card:cardArrayList){
            map.put(card.getNumber(),map.get(card.getNumber())==null ? 1 : map.get(card.getNumber())+1);
        }
        if (map.size()==5){
            return cardArrayList.get(4).getNumber().getNumber();
        }

        return 0;
    }
    //同花
    public boolean flush(ArrayList<Card> cardArrayList){
        Set<Type> typeSet = new HashSet<>();
        for(Card card:cardArrayList){
            typeSet.add(card.getType());
        }
        return typeSet.size()==1;
    }
    //顺子
    public int straight(ArrayList<Card> cardArrayList){
        if (cardArrayList.get(4).getNumber().getNumber() == cardArrayList.get(0).getNumber().getNumber()+4){
            return cardArrayList.get(4).getNumber().getNumber();
        }
        return  0;
    }

    private class CardComparator implements Comparator<Card>{
        @Override
        public int compare(Card card1, Card card2) {
            return card1.getNumber().getNumber()- card2.getNumber().getNumber();
        }
    }


}
