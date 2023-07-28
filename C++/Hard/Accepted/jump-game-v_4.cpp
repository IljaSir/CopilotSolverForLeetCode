class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> order(n);
        iota(order.begin(), order.end(), 0);
        sort(order.begin(), order.end(), [&](int a, int b) {
            return arr[a] < arr[b];
        });
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int idx = order[i];
            for (int j = idx - 1; j >= max(0, idx - d); j--) {
                if (arr[j] >= arr[idx]) break;
                dp[idx] = max(dp[idx], dp[j] + 1);
            }
            for (int j = idx + 1; j <= min(n - 1, idx + d); j++) {
                if (arr[j] >= arr[idx]) break;
                dp[idx] = max(dp[idx], dp[j] + 1);
            }
            ans = max(ans, dp[idx]);
        }
        return ans;
    }
};