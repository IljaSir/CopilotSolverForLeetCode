class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int res = 0;
        int minDiff = INT_MAX;
        for (auto base : baseCosts) {
            if (abs(base - target) < minDiff) {
                minDiff = abs(base - target);
                res = base;
            }
            dfs(toppingCosts, base, 0, target, minDiff, res);
        }
        return res;
    }
    
    void dfs(vector<int>& toppingCosts, int cost, int idx, int target, int& minDiff, int& res) {
        if (abs(cost - target) < minDiff) {
            minDiff = abs(cost - target);
            res = cost;
        }
        if (idx == toppingCosts.size()) return;
        dfs(toppingCosts, cost, idx + 1, target, minDiff, res);
        dfs(toppingCosts, cost + toppingCosts[idx], idx + 1, target, minDiff, res);
        dfs(toppingCosts, cost + toppingCosts[idx] * 2, idx + 1, target, minDiff, res);
    }
};