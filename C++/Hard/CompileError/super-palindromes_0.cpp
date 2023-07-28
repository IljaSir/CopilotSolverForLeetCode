class Solution {
public:
    int superpalindromesInRange(string left, string right) {
        
        long long L = stoll(left);
        long long R = stoll(right);
        int magic = 100000;
        int ans = 0;
        for (int k = 1; k < magic; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 2; i >= 0; --i)
                s += s[i];
            long long v = stoll(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                ans++;
        }
        for (int k = 1; k < magic; ++k) {
            string s = to_string(k);
            for (int i = s.size() - 1; i >= 0; --i)
                s += s[i];
            long long v = stoll(s);
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v))
                ans++;
        }
        return ans;
    }
};