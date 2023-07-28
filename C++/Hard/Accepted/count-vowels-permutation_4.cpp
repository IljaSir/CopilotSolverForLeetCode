class Solution {
public:
    int countVowelPermutation(int n) {
        
        const int M = 1000000007;
        long long a = 1, e = 1, i = 1, o = 1, u = 1;
        while (--n) {
            long long a2 = e, e2 = a + i, i2 = a + e + o + u, o2 = i + u, u2 = a;
            a = a2 % M, e = e2 % M, i = i2 % M, o = o2 % M, u = u2 % M;
        }
        return (a + e + i + o + u) % M;
    }
};