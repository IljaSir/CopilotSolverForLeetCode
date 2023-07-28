class Solution {
public:
    string subStrHash(string s, int power, int modulo, int k, int hashValue) {
        
        int n = s.length();
        vector<int> p(n, 1);
        for (int i = 1; i < n; ++i) {
            p[i] = (p[i - 1] * power) % modulo;
        }
        vector<int> h(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            h[i + 1] = (h[i] + (s[i] - 'a' + 1) * p[i]) % modulo;
        }
        for (int i = 0; i + k <= n; ++i) {
            int curHash = (h[i + k] + modulo - h[i]) % modulo;
            if (curHash == (hashValue * p[i]) % modulo) {
                return s.substr(i, k);
            }
        }
        return "";
    }
};