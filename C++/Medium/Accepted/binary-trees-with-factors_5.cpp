class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        
        sort(arr.begin(), arr.end());
        unordered_map<int, long> dp;
        long res = 0;
        for (int i = 0; i < arr.size(); i++) {
            dp[arr[i]] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    dp[arr[i]] += dp[arr[j]] * dp[arr[i] / arr[j]];
                }
            }
            res += dp[arr[i]];
        }
        return res % (int)(1e9 + 7);
    }
};