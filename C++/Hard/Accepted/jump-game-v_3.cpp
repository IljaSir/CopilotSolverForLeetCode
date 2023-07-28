class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> order(n);
        iota(order.begin(), order.end(), 0);
        sort(order.begin(), order.end(), [&](int i, int j) {
            return arr[i] < arr[j];
        });
        for (int i : order) {
            for (int j = i + 1; j <= min(i + d, n - 1) && arr[j] < arr[i]; ++j) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
            for (int j = i - 1; j >= max(i - d, 0) && arr[j] < arr[i]; --j) {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};