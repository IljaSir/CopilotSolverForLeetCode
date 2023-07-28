class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long n = 0;
        for (char c : s) {
            if (isdigit(c)) n *= (c - '0');
            else n++;
        }
        for (int i = s.size() - 1; i >= 0; i--) {
            k %= n;
            if (k == 0 && isalpha(s[i])) return string(1, s[i]);
            if (isdigit(s[i])) n /= (s[i] - '0');
            else n--;
        }
        return "";
    }
};