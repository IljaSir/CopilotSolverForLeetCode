class Solution {
public:
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        
        sort(arr2.begin(), arr2.end());
        arr2.erase(unique(arr2.begin(), arr2.end()), arr2.end());
        int n = arr1.size(), m = arr2.size();
        vector<vector<int>> dp(n, vector<int>(m + 1, INT_MAX));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                    continue;
                }
                if (arr1[i - 1] < arr1[i]) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j]);
                    }
                }
                if (j > 0) {
                    int p = upper_bound(arr2.begin(), arr2.end(), arr1[i - 1]) - arr2.begin();
                    if (p < m && arr2[p] < arr1[i]) {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= m; i++) {
            res = min(res, dp[n - 1][i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};