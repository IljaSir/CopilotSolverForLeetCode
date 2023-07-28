class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int n = costs.size();
        int cnt[100001] = {0};
        for (int i = 0; i < n; ++i) {
            ++cnt[costs[i]];
        }
        int res = 0;
        for (int i = 1; i <= 100000; ++i) {
            if (cnt[i] > 0) {
                if (coins >= i) {
                    int k = min(cnt[i], coins / i);
                    res += k;
                    coins -= k * i;
                }
            }
        }
        return res;
    }
};