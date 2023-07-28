class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        
        int result = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int full = empty / numExchange;
            result += full;
            empty = full + empty % numExchange;
        }
        return result;
    }
};