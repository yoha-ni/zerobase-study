package dev.yoha_ni.study.month_02.week6.day3;

import java.io.*;
import java.util.*;

public class GreedyBackpack {

    public static class Item implements Comparable<Item>{
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item other) {
            double ratio1 = (double) this.value / this.weight;
            double ratio2 = (double) other.value / other.weight;
            return Double.compare(ratio2, ratio1);
        }

        @Override
        public String toString(){
            return String.format("[%s, %s, %s]", weight, value, ((double) value / weight));
        }
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = br.readLine().split(" ");
        int n = Integer.parseInt(inputData[0]);
        int w = Integer.parseInt(inputData[1]);

        List<Item> items = new ArrayList<>();
        for (int i = 0 ; i < n ; i ++){
            inputData = br.readLine().split(" ");
            int wight = Integer.parseInt(inputData[0]);
            int value = Integer.parseInt(inputData[1]);
            items.add(new Item(wight, value));
        }

        Collections.sort(items);

        int totalValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= w) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                int remainWeight = w - currentWeight;
                totalValue += (item.value * remainWeight) / item.weight;
                break;
            }
        }

        System.out.println("totalValue = " + totalValue);
    }
}
