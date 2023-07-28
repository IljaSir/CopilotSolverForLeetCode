class Solution {
public:
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                cnt++;
            } else {
                if (k < (1 << cnt)) {
                    break;
                }
                k -= 1 << cnt;
                cnt = 0;
                ans++;
            }
        }
        return ans + min(cnt, __builtin_popcount(k));
    }
};