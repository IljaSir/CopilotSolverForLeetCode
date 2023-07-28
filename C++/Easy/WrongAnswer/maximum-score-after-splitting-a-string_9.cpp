class Solution {
public:
    int maxScore(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (char c : s) {
            if (c == '0') cnt++;
        }
        int res = 0;
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == '0') left++;
            else left--;
            res = max(res, left + cnt);
        }
        return res;
    }
};