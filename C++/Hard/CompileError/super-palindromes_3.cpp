class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        long long l = stoll(left), r = stoll(right);
        int res = 0;
        for (int k = 1; k < 100000; ++k) {
            string s = to_string(k), t = s;
            reverse(t.begin(), t.end());
            long long v = stoll(s + t);
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ++res;
        }
        for (int k = 1; k < 100000; ++k) {
            string s = to_string(k), t = s;
            reverse(t.begin(), t.end());
            long long v = stoll(s + t.substr(1));
            v *= v;
            if (v > r) break;
            if (v >= l && isPalindrome(v)) ++res;
        }
        return res;
    }
};