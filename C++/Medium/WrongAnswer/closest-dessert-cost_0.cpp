class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int n = baseCosts.size();
        int m = toppingCosts.size();
        int minDiff = INT_MAX;
        int minCost = INT_MAX;
        for (int i = 0; i < n; ++i) {
            int cost = baseCosts[i];
            int diff = abs(target - cost);
            if (diff < minDiff) {
                minDiff = diff;
                minCost = cost;
            } else if (diff == minDiff) {
                minCost = min(minCost, cost);
            }
            dfs(toppingCosts, m, 0, cost, target, minDiff, minCost);
        }
        return minCost;
    }
    
    void dfs(vector<int>& toppingCosts, int m, int idx, int cost, int target, int& minDiff, int& minCost) {
        if (idx == m) {
            return;
        }
        int diff = abs(target - cost);
        if (diff < minDiff) {
            minDiff = diff;
            minCost = cost;
        } else if (diff == minDiff) {
            minCost = min(minCost, cost);
        }
        int toppingCost = toppingCosts[idx];
        for (int i = 0; i < 3; ++i) {
            cost += toppingCost * i;
            dfs(toppingCosts, m, idx + 1, cost, target, minDiff, minCost);
            cost -= toppingCost * i;
        }
    }
};