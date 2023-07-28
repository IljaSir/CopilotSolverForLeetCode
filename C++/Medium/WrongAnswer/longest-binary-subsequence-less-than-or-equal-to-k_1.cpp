class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = i; j < n; ++j) {
                sum = sum * 2 + s[j] - '0';
                if (sum > k) break;
                ans = max(ans, j - i + 1);
            }
        }
        return ans;
    }
};