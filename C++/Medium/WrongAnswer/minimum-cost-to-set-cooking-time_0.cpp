class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int ans = INT_MAX;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i * 60 + j == targetSeconds) {
                    int cost = 0;
                    int t = i;
                    while (t) {
                        cost += moveCost;
                        t /= 10;
                    }
                    cost += pushCost * (i == 0 ? 1 : 2);
                    t = j;
                    while (t) {
                        cost += moveCost;
                        t /= 10;
                    }
                    cost += pushCost * (j == 0 ? 1 : 2);
                    ans = min(ans, cost);
                }
            }
        }
        return ans;
    }
};