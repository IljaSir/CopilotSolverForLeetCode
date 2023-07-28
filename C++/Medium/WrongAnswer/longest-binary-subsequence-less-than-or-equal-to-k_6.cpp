class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            int sum = 0;
            for (int j = i; j < n; ++j) {
                if (s[j] == '0') {
                    ++cnt;
                }
                sum = sum * 2 + s[j] - '0';
                if (cnt <= k && sum <= k) {
                    ans = max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return ans;
    }
};