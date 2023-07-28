class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            mp[arr[i]] = i;
        }
        vector<vector<int>> dp(n, vector<int>(n, 2));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (mp.find(arr[j] - arr[i]) != mp.end()) {
                    int k = mp[arr[j] - arr[i]];
                    if (k < i) {
                        dp[i][j] = dp[k][i] + 1;
                    }
                }
                ans = max(ans, dp[i][j]);
            }
        }
        return ans > 2 ? ans : 0;
    }
};