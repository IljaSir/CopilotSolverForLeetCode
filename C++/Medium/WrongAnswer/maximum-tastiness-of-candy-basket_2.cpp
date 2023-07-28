class Solution {
public:
    int maximumTastiness(vector<int>& price, int k) {
        
        sort(price.begin(), price.end());
        int n = price.size();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += price[n - i - 1];
        }
        int sum = ans;
        for (int i = 1; i <= n - k; i++) {
            sum -= price[i - 1];
            sum += price[n - k - i];
            ans = max(ans, sum);
        }
        return ans;
    }
};