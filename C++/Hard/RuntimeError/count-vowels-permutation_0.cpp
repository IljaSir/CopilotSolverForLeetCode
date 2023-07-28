class Solution {
public:
    int countVowelPermutation(int n) {
        
        if (n == 1) return 5;
        if (n == 2) return 10;
        if (n == 3) return 19;
        if (n == 4) return 35;
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        int a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0;
        int mod = 1000000007;
        for (int j = 1; j < n; j++) {
            a2 = (e + i + u) % mod;
            e2 = (a + i) % mod;
            i2 = (e + o) % mod;
            o2 = i % mod;
            u2 = (i + o) % mod;
            a = a2;
            e = e2;
            i = i2;
            o = o2;
            u = u2;
        }
        return (a + e + i + o + u) % mod;
    }
};