class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        
        int n = arr.size();
        long long int mod = 1e9 + 7;
        sort(arr.begin(), arr.end());
        map<int, long long int> dp;
        for (int i = 0; i < n; i++) {
            dp[arr[i]] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    dp[arr[i]] += dp[arr[j]] * dp[arr[i] / arr[j]];
                    dp[arr[i]] %= mod;
                }
            }
        }
        long long int res = 0;
        for (auto it : dp) {
            res += it.second;
            res %= mod;
        }
        return res;
    }
};