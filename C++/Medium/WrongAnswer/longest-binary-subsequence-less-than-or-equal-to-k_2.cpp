class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur = (cur << 1) + s[j] - '0';
                if (cur <= k) {
                    ans = max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
};