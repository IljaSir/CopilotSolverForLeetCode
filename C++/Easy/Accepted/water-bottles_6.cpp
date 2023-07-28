class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        
        int numFullBottles = 0;
        int numEmptyBottles = 0;
        while (numBottles > 0) {
            numFullBottles += numBottles;
            numEmptyBottles += numBottles;
            numBottles = numEmptyBottles / numExchange;
            numEmptyBottles = numEmptyBottles % numExchange;
        }
        return numFullBottles;
    }
};