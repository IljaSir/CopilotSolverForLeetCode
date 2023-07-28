class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int n = s.length();
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || s[i] > s[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};