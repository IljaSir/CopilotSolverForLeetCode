class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        if (n < 3) return 0;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            mp[arr[i]] = i;
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            for (int j = i - 1; j >= 1; --j) {
                int k = mp.find(arr[i] - arr[j]) != mp.end() ? mp[arr[i] - arr[j]] : -1;
                if (k >= 0 && k < j) {
                    dp[j][i] = dp[k][j] + 1;
                    ans = max(ans, dp[j][i]);
                }
            }
        }
        return ans >= 2 ? ans + 2 : 0;
    }
};