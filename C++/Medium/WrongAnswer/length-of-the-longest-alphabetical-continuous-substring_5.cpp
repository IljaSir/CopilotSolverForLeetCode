class Solution {
public:
    int longestContinuousSubstring(string s) {
        
        int n = s.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (j == i || s[j] > s[j - 1]) {
                    cnt++;
                } else {
                    break;
                }
            }
            res = max(res, cnt);
        }
        return res;
    }
};