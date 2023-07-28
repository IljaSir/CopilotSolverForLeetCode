class Solution {
public:
    int countVowelPermutation(int n) {
        
        int a=1, e=1, i=1, o=1, u=1;
        int mod = 1000000007;
        for (int j=1; j<n; j++) {
            int new_a = (e + i + u) % mod;
            int new_e = (a + i) % mod;
            int new_i = (e + o) % mod;
            int new_o = i;
            int new_u = (i + o) % mod;
            a = new_a;
            e = new_e;
            i = new_i;
            o = new_o;
            u = new_u;
        }
        return (a + e + i + o + u) % mod;
    }
};