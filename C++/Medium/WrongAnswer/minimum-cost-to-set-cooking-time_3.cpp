class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int minCost = INT_MAX;
        vector<int> digit = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        int seconds = digit[i] * 600 + digit[j] * 60 + digit[k] * 10 + digit[l];
                        if (seconds > targetSeconds) {
                            continue;
                        }
                        int cost = 0;
                        cost += abs(startAt - digit[i]) * moveCost;
                        cost += digit[i] * pushCost;
                        cost += abs(digit[i] - digit[j]) * moveCost;
                        cost += digit[j] * pushCost;
                        cost += abs(digit[j] - digit[k]) * moveCost;
                        cost += digit[k] * pushCost;
                        cost += abs(digit[k] - digit[l]) * moveCost;
                        cost += digit[l] * pushCost;
                        minCost = min(minCost, cost);
                    }
                }
            }
        }
        return minCost;
    }
};