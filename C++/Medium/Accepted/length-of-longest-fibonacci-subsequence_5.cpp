class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[arr[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[j] - arr[i];
                if (m.find(target) != m.end() && m[target] < i) {
                    dp[i][j] = dp[m[target]][i] + 1;
                }
                ans = max(ans, dp[i][j]);
            }
        }
        return ans > 0 ? ans + 2 : 0;
    }
};