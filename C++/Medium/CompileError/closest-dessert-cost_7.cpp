class Solution {
public:
    int closestCost(vector<int>& baseCosts, vector<int>& toppingCosts, int target) {
        
        int ans = 0;
        for (int i = 0; i < baseCosts.size(); i++) {
            int base = baseCosts[i];
            ans = min(ans, base, target);
            for (int j = 0; j < toppingCosts.size(); j++) {
                int topping = toppingCosts[j];
                ans = min(ans, base + topping, target);
                for (int k = j + 1; k < toppingCosts.size(); k++) {
                    int topping2 = toppingCosts[k];
                    ans = min(ans, base + topping + topping2, target);
                }
            }
        }
        return ans;
    }
    
    int min(int a, int b, int target) {
        if (abs(a - target) < abs(b - target)) {
            return a;
        } else if (abs(a - target) > abs(b - target)) {
            return b;
        } else {
            return min(a, b);
        }
    }
};