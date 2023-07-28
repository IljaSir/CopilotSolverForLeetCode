class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int sum = 0;
        int remainder = 0;
        while (numBottles > 0) {
            sum += numBottles;
            int newBottles = numBottles + remainder;
            numBottles = newBottles / numExchange;
            remainder = newBottles % numExchange;
        }
        return sum;
    }
}