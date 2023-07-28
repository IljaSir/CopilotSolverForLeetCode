class Solution {
public:
    bool splitString(string s) {
        
        return splitString(s, 0, 0, true);
    }
    bool splitString(string& s, int i, long long prev, bool first) {
        if (i == s.size()) {
            return !first;
        }
        long long cur = 0;
        for (int j = i; j < s.size(); ++j) {
            cur = cur * 10 + s[j] - '0';
            if (cur > prev) {
                break;
            }
            if (cur == prev - 1 && splitString(s, j + 1, cur, false)) {
                return true;
            }
        }
        return false;
    }
};