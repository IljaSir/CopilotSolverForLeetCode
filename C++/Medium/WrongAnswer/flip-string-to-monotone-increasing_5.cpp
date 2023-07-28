class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.size();
        int cnt0 = 0, cnt1 = 0;
        for (char c : s) {
            if (c == '0') {
                ++cnt0;
            } else {
                ++cnt1;
            }
        }
        int ans = cnt1;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '0') {
                --cnt0;
            } else {
                --cnt1;
            }
            ans = min(ans, cnt0 + cnt1);
        }
        return ans;
    }
};