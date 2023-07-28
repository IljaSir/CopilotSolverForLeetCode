class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;
        int minCost = INT_MAX;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i * 60 + j == targetSeconds) {
                    int cost = 0;
                    int temp = i;
                    while (temp > 0) {
                        cost += abs(temp % 10 - startAt) * pushCost;
                        temp /= 10;
                    }
                    temp = j;
                    while (temp > 0) {
                        cost += abs(temp % 10 - startAt) * pushCost;
                        temp /= 10;
                    }
                    minCost = min(minCost, cost);
                }
            }
        }
        return minCost;
    }
};