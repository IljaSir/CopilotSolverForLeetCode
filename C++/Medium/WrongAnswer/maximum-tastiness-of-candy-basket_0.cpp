class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += price[i];
        }
        for (int i = k; i < price.size(); ++i) {
            ans = max(ans, ans - price[i - k] + price[i]);
        }
        return ans;
    }
};