class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int ans = INT_MAX;
        for (auto c : baseCosts) {
            int t = c;
            if (abs(t - target) < abs(ans - target)) ans = t;
            if (t >= target) continue;
            for (int i = 0; i < toppingCosts.size(); ++i) {
                t += toppingCosts[i];
                if (abs(t - target) < abs(ans - target)) ans = t;
                if (t >= target) continue;
                for (int j = i + 1; j < toppingCosts.size(); ++j) {
                    t += toppingCosts[j];
                    if (abs(t - target) < abs(ans - target)) ans = t;
                    if (t >= target) continue;
                    t -= toppingCosts[j];
                }
                t -= toppingCosts[i];
            }
        }
        return ans;
    }
};