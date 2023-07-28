class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        
        int n = arr.size();
        int maxLen = 0;
        unordered_map<int, int> pos;
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }
        vector<vector<int>> dp(n, vector<int>(n, 2));
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[j] - arr[i];
                if (target >= arr[i]) {
                    break;
                }
                if (pos.count(target)) {
                    dp[i][j] = dp[pos[target]][i] + 1;
                }
                maxLen = max(maxLen, dp[i][j]);
            }
        }
        return maxLen > 2 ? maxLen : 0;
    }
};