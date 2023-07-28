class Solution {
public:
    int countBinarySubstrings(string s) {
        
        int ans = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < s.size(); i++) {
            if (s[i] == s[i - 1]) {
                cur++;
            } else {
                ans += min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        ans += min(pre, cur);
        return ans;
    }
};