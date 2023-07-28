class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int res = 0;
        int diff = INT_MAX;
        for (int i = 0; i < baseCosts.size(); i++) {
            int cost = baseCosts[i];
            if (abs(target - cost) < diff) {
                res = cost;
                diff = abs(target - cost);
            }
            for (int j = 0; j < toppingCosts.size(); j++) {
                int cost1 = cost + toppingCosts[j];
                if (abs(target - cost1) < diff) {
                    res = cost1;
                    diff = abs(target - cost1);
                }
                for (int k = j + 1; k < toppingCosts.size(); k++) {
                    int cost2 = cost + toppingCosts[j] + toppingCosts[k];
                    if (abs(target - cost2) < diff) {
                        res = cost2;
                        diff = abs(target - cost2);
                    }
                }
            }
        }
        return res;
    }
};