package fractional_knapsack;

import java.util.Arrays;
import java.util.Comparator;

public class fractional_knapsack {

    public static void main(String[] args) {
        int[] weights = {10, 40, 20, 30};
        int[] values = {60, 40, 100, 120};
        int capacity = 50;

        System.out.println("Maximum value we can obtain = " + getMaxValue(weights, values, capacity));
    }

    private static double getMaxValue(int[] weights, int[] values, int capacity) {
        Item[] iVal = new Item[weights.length];

        for (int i = 0; i < weights.length; i++) {
            iVal[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(iVal, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0.0;
        for (Item i : iVal) {
            int curWt = (int) i.weight;
            int curVal = (int) i.value;

            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                totalValue += (curVal * ((double) capacity / (double) curWt));
                break;
            }
        }

        return totalValue;
    }

    static class Item {
        Double cost;
        double weight, value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            cost = (double) value / weight;
        }
    }
}
