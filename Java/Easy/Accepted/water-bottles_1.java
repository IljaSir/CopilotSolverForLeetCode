class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int result = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            int fullBottles = emptyBottles / numExchange;
            result += fullBottles;
            emptyBottles = emptyBottles % numExchange + fullBottles;
        }
        return result;
    }
}