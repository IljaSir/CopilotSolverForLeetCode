class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int res = 0;
        int minDiff = INT_MAX;
        for (int base : baseCosts) {
            int diff = abs(base - target);
            if (diff < minDiff) {
                minDiff = diff;
                res = base;
            }
            dfs(base, toppingCosts, 0, target, res, minDiff);
        }
        return res;
    }
};