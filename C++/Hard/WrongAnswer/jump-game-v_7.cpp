class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> v(n);
        iota(v.begin(), v.end(), 0);
        sort(v.begin(), v.end(), [&](int a, int b) { return arr[a] < arr[b]; });
        for (int i = 0; i < n; ++i) {
            int x = v[i];
            for (int j = x + 1; j <= x + d && j < n; ++j) {
                if (arr[j] >= arr[x]) break;
                dp[j] = max(dp[j], dp[x] + 1);
            }
            for (int j = x - 1; j >= x - d && j >= 0; --j) {
                if (arr[j] >= arr[x]) break;
                dp[j] = max(dp[j], dp[x] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};