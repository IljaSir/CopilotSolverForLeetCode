class Solution {
public:
    int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int ans = INT_MAX;
        auto [min, sec] = getMinSec(targetSeconds);
        auto [minStart, secStart] = getMinSec(startAt);
        int cost = 0;
        int minCost = min * pushCost;
        int secCost = sec * pushCost;
        int minStartCost = minStart * moveCost;
        int secStartCost = secStart * moveCost;
        int minMoveCost = 9 * moveCost;
        int secMoveCost = 9 * moveCost;
        for (int i = 0; i < 2; ++i) {
            int minCost = min * pushCost;
            int secCost = sec * pushCost;
            int minStartCost = minStart * moveCost;
            int secStartCost = secStart * moveCost;
            int minMoveCost = 9 * moveCost;
            int secMoveCost = 9 * moveCost;
            if (i == 1) {
                minCost += minStartCost;
                minStartCost = 0;
                minMoveCost = 0;
            }
            cost = minCost + secCost + minStartCost + secStartCost + minMoveCost + secMoveCost;
            ans = min(ans, cost);
            swap(min, sec);
            swap(minStart, secStart);
            swap(minMoveCost, secMoveCost);
        }
        return ans;
    }
};