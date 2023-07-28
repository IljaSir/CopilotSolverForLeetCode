class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int ans = baseCosts[0];
        for (auto base : baseCosts) {
            dfs(ans, base, toppingCosts, target, 0);
        }
        return ans;
    }
    void dfs(int& ans, int base, vector<int>& toppingCosts, int target, int idx) {
        if (idx >= toppingCosts.size()) {
            if (abs(ans - target) > abs(base - target)) {
                ans = base;
            } else if (abs(ans - target) == abs(base - target)) {
                ans = min(ans, base);
            }
            return;
        }
        dfs(ans, base, toppingCosts, target, idx + 1);
        dfs(ans, base + toppingCosts[idx], toppingCosts, target, idx + 1);
        dfs(ans, base + toppingCosts[idx] * 2, toppingCosts, target, idx + 1);
    }
};