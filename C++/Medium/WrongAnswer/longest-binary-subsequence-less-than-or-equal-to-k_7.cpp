class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        vector<int> dp(n + 1, 0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + (s[i] - '0');
        }
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (dp[mid] - dp[i] <= k) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res = max(res, l - i);
        }
        return res;
    }
};