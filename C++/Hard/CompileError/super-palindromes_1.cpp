class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        long long l = stoll(left), r = stoll(right);
        int res = 0;
        for (int k = 1; k < 100000; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 2; i >= 0; --i) {
                s += s[i];
            }
            long long v = stoll(s);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ++res;
        }
        for (int k = 1; k < 100000; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 1; i >= 0; --i) {
                s += s[i];
            }
            long long v = stoll(s);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ++res;
        }
        return res;
    }
};