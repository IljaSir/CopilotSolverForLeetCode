class Solution {
public:
    long long minCost(vector<int>& basket1, vector<int>& basket2) {
        
        long long result = 0;
        for (int i = 0; i < basket1.size(); i++) {
            if (basket1[i] != basket2[i]) {
                result += min(basket1[i], basket2[i]);
            }
        }
        return result;
    }
};