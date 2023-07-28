class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        int res = 0;
        for (int i = 2; i < n; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    dp[r][i] = dp[l][r] + 1;
                    res = max(res, dp[r][i]);
                    l++;
                    r--;
                } else if (arr[l] + arr[r] < arr[i]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res == 0 ? 0 : res + 2;
    }
};