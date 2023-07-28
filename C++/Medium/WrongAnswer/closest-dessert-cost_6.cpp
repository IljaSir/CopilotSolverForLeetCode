class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int min_diff = INT_MAX;
        int min_cost = INT_MAX;
        for (int base : baseCosts) {
            int cost = base;
            int diff = abs(target - cost);
            if (diff < min_diff) {
                min_diff = diff;
                min_cost = cost;
            } else if (diff == min_diff) {
                min_cost = min(min_cost, cost);
            }
            for (int topping : toppingCosts) {
                cost += topping;
                diff = abs(target - cost);
                if (diff < min_diff) {
                    min_diff = diff;
                    min_cost = cost;
                } else if (diff == min_diff) {
                    min_cost = min(min_cost, cost);
                }
                cost -= topping;
                cost += topping * 2;
                diff = abs(target - cost);
                if (diff < min_diff) {
                    min_diff = diff;
                    min_cost = cost;
                } else if (diff == min_diff) {
                    min_cost = min(min_cost, cost);
                }
                cost -= topping * 2;
            }
        }
        return min_cost;
    }
};