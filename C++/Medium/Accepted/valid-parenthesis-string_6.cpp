class Solution {
public:
    bool checkValidString(string s) {
        
        int n = s.size();
        if (n == 0) {
            return true;
        }
        int lo = 0, hi = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                ++lo;
                ++hi;
            } else if (s[i] == ')') {
                --lo;
                --hi;
            } else {
                --lo;
                ++hi;
            }
            if (hi < 0) {
                return false;
            }
            lo = max(0, lo);
        }
        return lo == 0;
    }
};