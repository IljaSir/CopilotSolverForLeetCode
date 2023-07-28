class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) return 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[arr[i]] = i;
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[i] + arr[j];
                if (m.find(target) == m.end()) continue;
                dp[i][j] = dp[j][m[target]] + 1;
                res = max(res, dp[i][j]);
            }
        }
        return res == 0 ? 0 : res + 2;
    }
};