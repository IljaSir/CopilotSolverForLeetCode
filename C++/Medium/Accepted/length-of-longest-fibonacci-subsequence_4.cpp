class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size(), ans = 0;
        vector<vector<int>> dp(n, vector<int>(n, 2));
        unordered_map<int, int> pos;
        for (int i = 0; i < n; ++i) pos[arr[i]] = i;
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                int i = pos.find(arr[k] - arr[j]) == pos.end() ? -1 : pos[arr[k] - arr[j]];
                if (i >= 0 && i < j) {
                    dp[j][k] = dp[i][j] + 1;
                    ans = max(ans, dp[j][k]);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }
};