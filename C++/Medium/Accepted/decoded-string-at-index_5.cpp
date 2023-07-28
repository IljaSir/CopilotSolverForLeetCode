class Solution {
public:
    string decodeAtIndex(string s, int k) {
        
        long long n = 0;
        for (char c : s) {
            n = isdigit(c) ? n * (c - '0') : n + 1;
        }
        for (auto it = s.rbegin(); it != s.rend(); ++it) {
            char c = *it;
            k %= n;
            if (k == 0 && isalpha(c)) {
                return string(1, c);
            }
            if (isdigit(c)) {
                n /= c - '0';
            } else {
                n--;
            }
        }
        return "";
    }
};