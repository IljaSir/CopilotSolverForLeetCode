class Solution {
public:
    string subStrHash(string s, int power, int modulo, int k, int hashValue) {
        
        int n = s.size();
        long long p = 1;
        long long h = 0;
        for (int i = 0; i < k; ++i) {
            h = (h + (s[i] - 'a' + 1) * p) % modulo;
            p = p * power % modulo;
        }
        if (h == hashValue) return s.substr(0, k);
        for (int i = k; i < n; ++i) {
            h = (h - (s[i - k] - 'a' + 1)) * power % modulo;
            h = (h + modulo) % modulo;
            h = (h + (s[i] - 'a' + 1) * p) % modulo;
            if (h == hashValue) return s.substr(i - k + 1, k);
        }
        return "";
    }
};