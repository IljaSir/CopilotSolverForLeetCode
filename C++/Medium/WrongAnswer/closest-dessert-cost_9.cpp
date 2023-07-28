class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int ans = 0, minDiff = 99999;
        for (int baseCost : baseCosts) {
            int diff = abs(target - baseCost);
            if (diff < minDiff) {
                ans = baseCost;
                minDiff = diff;
            }
            for (int i = 0; i < toppingCosts.size(); i++) {
                int sum = baseCost + toppingCosts[i];
                int diff = abs(target - sum);
                if (diff < minDiff) {
                    ans = sum;
                    minDiff = diff;
                }
                for (int j = i + 1; j < toppingCosts.size(); j++) {
                    int sum = baseCost + toppingCosts[i] + toppingCosts[j];
                    int diff = abs(target - sum);
                    if (diff < minDiff) {
                        ans = sum;
                        minDiff = diff;
                    }
                }
            }
        }
        return ans;
    }
};