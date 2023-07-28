class Solution {
public:
    int countVowelPermutation(int n) {
        
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        int mod = 1e9 + 7;
        for (int j = 1; j < n; ++j) {
            int a1 = (e + i + u) % mod;
            int e1 = (a + i) % mod;
            int i1 = (e + o) % mod;
            int o1 = i;
            int u1 = (i + o) % mod;
            a = a1;
            e = e1;
            i = i1;
            o = o1;
            u = u1;
        }
        return (a + e + i + o + u) % mod;
    }
};