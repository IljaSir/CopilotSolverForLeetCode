class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long long n = 0;
        for (auto c : s) {
            if (isdigit(c)) {
                n *= c - '0';
            } else {
                n++;
            }
        }
        for (auto it = s.rbegin(); it != s.rend(); ++it) {
            k %= n;
            if (k == 0 && isalpha(*it)) {
                return string(1, *it);
            }
            if (isdigit(*it)) {
                n /= *it - '0';
            } else {
                n--;
            }
        }
        return "";
    }
};