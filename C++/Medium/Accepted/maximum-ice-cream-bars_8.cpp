class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int count = 0;
        int n = costs.size();
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(costs[i] > max) max = costs[i];
        }
        vector<int> cnt(max + 1, 0);
        for(int i = 0; i < n; i++) {
            cnt[costs[i]]++;
        }
        for(int i = 1; i <= max; i++) {
            if(coins >= i) {
                int k = min(cnt[i], coins / i);
                count += k;
                coins -= k * i;
            }
        }
        return count;
    }
};