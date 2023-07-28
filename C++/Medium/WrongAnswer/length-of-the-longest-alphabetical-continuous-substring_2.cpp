class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int ans = 0, cnt = 0;
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] > s[i - 1]) {
                ++cnt;
            } else {
                cnt = 0;
            }
            ans = max(ans, cnt);
        }
        return ans + 1;
    }
};