class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int empty = 0;
        int total = 0;
        while (numBottles > 0) {
            total += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty = empty % numExchange;
        }
        return total;
    }
}