class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int ans = 0;
        int minCost = 1000000;
        for (int i = 0; i < 4; i++) {
            int digit = (targetSeconds % 10);
            targetSeconds /= 10;
            int cost = abs(digit - startAt) * moveCost;
            if (cost < minCost) {
                ans += cost;
                minCost = cost;
            } else {
                ans += minCost;
            }
            ans += pushCost;
            startAt = digit;
        }
        return ans;
    }
};