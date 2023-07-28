class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] > s[i-1]) {
                ++cnt;
            } else {
                ans = max(ans, cnt+1);
                cnt = 0;
            }
        }
        return max(ans, cnt+1);
    }
};