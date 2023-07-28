class Solution {
public:
    string subStrHash(string s, int power, int modulo, int k, int hashValue) {
        
        int n = s.size();
        int p = 1;
        for (int i = 0; i < k; i++) {
            p = (p * power) % modulo;
        }
        int hash = 0;
        for (int i = 0; i < k; i++) {
            hash = (hash * power + s[i] - 'a' + 1) % modulo;
        }
        if (hash == hashValue) return s.substr(0, k);
        for (int i = k; i < n; i++) {
            hash = (hash - (s[i - k] - 'a' + 1) * p % modulo + modulo) % modulo;
            hash = (hash * power + s[i] - 'a' + 1) % modulo;
            if (hash == hashValue) return s.substr(i - k + 1, k);
        }
        return "";
    }
};