class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int ans = 0;
        int minDiff = INT_MAX;
        for (int base : baseCosts) {
            for (int i = 0; i < (1 << toppingCosts.size()); i++) {
                int cost = base;
                for (int j = 0; j < toppingCosts.size(); j++) {
                    if (i & (1 << j)) {
                        cost += toppingCosts[j];
                    }
                }
                if (abs(target - cost) < minDiff) {
                    ans = cost;
                    minDiff = abs(target - cost);
                }
                else if (abs(target - cost) == minDiff) {
                    ans = min(ans, cost);
                }
            }
        }
        return ans;
    }
};