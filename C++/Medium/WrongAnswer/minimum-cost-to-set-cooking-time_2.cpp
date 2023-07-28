class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int res = INT_MAX;
        for (int i = 0; i < 100; ++i) {
            int a = i / 10, b = i % 10;
            int c = targetSeconds / 60, d = targetSeconds % 60;
            res = min(res, abs(a - startAt) * moveCost + abs(a - c) * pushCost + abs(b - d) * pushCost);
        }
        return res;
    }
};