class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int bucket[costs.size()+1] = {0};
        for (int i = 0; i < costs.size(); ++i) {
            ++bucket[costs[i]];
        }
        int ans = 0;
        for (int i = 0; i < costs.size()+1; ++i) {
            if (bucket[i] == 0) continue;
            if (coins >= i) {
                int tmp = min(bucket[i], coins/i);
                ans += tmp;
                coins -= tmp*i;
            } else {
                break;
            }
        }
        return ans;
    }
};