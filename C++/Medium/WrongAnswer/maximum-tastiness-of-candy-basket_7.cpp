class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int ans = price[n - 1] - price[0];
        for (int i = 1; i <= k - 1; ++i) {
            ans = max(ans, price[n - 1 - i] - price[i]);
        }
        return ans;
    }
};