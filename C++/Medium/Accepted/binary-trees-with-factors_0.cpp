class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        
        int mod = 1e9 + 7;
        sort(arr.begin(), arr.end());
        unordered_map<int, long> dp;
        for (int i = 0; i < arr.size(); ++i) {
            dp[arr[i]] = 1;
            for (int j = 0; j < i; ++j) {
                if (arr[i] % arr[j] == 0) {
                    dp[arr[i]] += dp[arr[j]] * dp[arr[i] / arr[j]];
                    dp[arr[i]] %= mod;
                }
            }
        }
        long ans = 0;
        for (auto& [k, v] : dp) {
            ans += v;
            ans %= mod;
        }
        return ans;
    }
};