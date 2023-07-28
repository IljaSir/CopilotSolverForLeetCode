class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[arr[i]] = i;
        }
        vector<vector<int>> dp(n, vector<int>(n, 2));
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = arr[j] - arr[i];
                if (k < arr[i] && m.count(k)) {
                    dp[i][j] = dp[m[k]][i] + 1;
                }
                res = max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
};