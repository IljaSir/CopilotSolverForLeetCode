class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        long long l = stoll(left);
        long long r = stoll(right);
        int res = 0;
        for (long long i = 1; i <= 100000; ++i) {
            string s = to_string(i);
            for (int j = s.size() - 2; j >= 0; --j) {
                s += s[j];
            }
            long long v = stoll(s);
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindrome(v)) {
                ++res;
            }
        }
        for (long long i = 1; i <= 100000; ++i) {
            string s = to_string(i);
            for (int j = s.size() - 1; j >= 0; --j) {
                s += s[j];
            }
            long long v = stoll(s);
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindrome(v)) {
                ++res;
            }
        }
        return res;
    }
};