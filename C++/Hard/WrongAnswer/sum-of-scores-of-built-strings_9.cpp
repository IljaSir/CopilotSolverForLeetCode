class Solution {
public:
    long long sumScores(string s) {
        
        long long n = s.size();
        long long s1 = 0;
        long long s2 = 0;
        for (long long i = 0; i < n; i++) {
            s1 += s[i] * (n - i);
            s2 += s[i] * (i + 1);
        }
        return s1 - s2;
    }
};