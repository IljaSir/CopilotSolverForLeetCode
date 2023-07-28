class Solution {
public:
    int countVowelPermutation(int n) {
        
        const int M = 1000000007;
        long long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int j = 2; j <= n; ++j) {
            long long na = (e + i + u) % M;
            long long ne = (a + i) % M;
            long long ni = (e + o) % M;
            long long no = i;
            long long nu = (i + o) % M;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return (a + e + i + o + u) % M;
    }
};