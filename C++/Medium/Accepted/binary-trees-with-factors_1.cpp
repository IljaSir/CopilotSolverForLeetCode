class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        
        const int mod = 1e9 + 7;
        int n = arr.size();
        sort(arr.begin(), arr.end());
        unordered_map<int, long> dp;
        for (int i = 0; i < n; ++i) {
            dp[arr[i]] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    dp[arr[i]] = (dp[arr[i]] + dp[arr[j]] * dp[arr[i] / arr[j]]) % mod;
                }
            }
        }
        long ans = 0;
        for (auto& [_, v] : dp) {
            ans = (ans + v) % mod;
        }
        return ans;
    }
};