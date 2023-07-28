class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        
        int n = costs.size();
        vector<int> cnt(100001);
        for (int x: costs) ++cnt[x];
        int ans = 0;
        for (int i = 1; i <= 100000; ++i) {
            if (coins >= i * cnt[i]) {
                ans += cnt[i];
                coins -= (i * cnt[i]);
            } else {
                ans += coins / i;
                break;
            }
        }
        return ans;
    }
};