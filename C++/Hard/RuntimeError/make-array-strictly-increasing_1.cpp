class Solution {
public:
    int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
        
        sort(arr2.begin(), arr2.end());
        arr2.erase(unique(arr2.begin(), arr2.end()), arr2.end());
        int n = arr1.size();
        int m = arr2.size();
        vector<vector<int>> dp(n, vector<int>(m + 1, INT_MAX));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                int val = j == 0 ? INT_MIN : arr2[j - 1];
                if (i == 0) {
                    if (arr1[i] > val) {
                        dp[i][j] = 0;
                    }
                } else {
                    if (arr1[i] > val && arr1[i] > arr1[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    if (arr1[i] > arr1[i - 1]) {
                        int pos = upper_bound(arr2.begin(), arr2.end(), arr1[i - 1]) - arr2.begin();
                        if (pos < m) {
                            dp[i][j] = min(dp[i][j], dp[i - 1][pos]);
                        }
                    }
                    if (val > arr1[i - 1]) {
                        int pos = upper_bound(arr2.begin(), arr2.end(), arr1[i - 1]) - arr2.begin();
                        if (pos < m) {
                            dp[i][j] = min(dp[i][j], dp[i][pos] + 1);
                        }
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i <= m; i++) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};