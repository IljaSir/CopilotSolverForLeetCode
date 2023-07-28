class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        
        int n = arr.size();
        if (n == 0) return 0;
        vector<int> dp(n, 1);
        unordered_map<int, int> m;
        for (int i = 0; i < n; ++i) {
            if (m.find(arr[i] - difference) != m.end()) {
                dp[i] = dp[m[arr[i] - difference]] + 1;
            }
            m[arr[i]] = i;
        }
        return *max_element(dp.begin(), dp.end());
    }
};