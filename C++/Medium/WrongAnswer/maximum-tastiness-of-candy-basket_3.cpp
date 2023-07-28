class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += price[n - i - 1];
        }
        int cur = ans;
        for (int i = 0; i < k - 1; i++) {
            cur -= price[n - i - 1];
            cur += price[i];
            ans = max(ans, cur);
        }
        return ans;
    }
};