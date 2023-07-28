class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.size();
        long long num = stoll(n);
        long long minDiff = LONG_MAX;
        long long minNum = 0;
        long long left = stoll(n.substr(0, (len + 1) / 2));
        for (int i = -1; i <= 1; i++) {
            long long cur = left + i;
            string s = to_string(cur);
            string t = s.substr(0, s.size() - (len & 1)) + string(s.rbegin(), s.rend());
            long long diff = abs(stoll(t) - num);
            if (diff == 0) {
                diff = LONG_MAX;
            }
            if (diff < minDiff) {
                minDiff = diff;
                minNum = stoll(t);
            } else if (diff == minDiff) {
                minNum = min(minNum, stoll(t));
            }
        }
        return to_string(minNum);
    }
};