class Solution {
public:
    int countHousePlacements(int n) {
        
        int a = 1, b = 1, c = 1, d = 1, e = 1, f = 1;
        for (int i = 1; i <= n; ++i) {
            int na = a + c + e;
            int nb = b + d + f;
            int nc = a + b + c + d + e + f;
            int nd = b + d + f;
            int ne = a + c + e;
            int nf = b + d + f;
            a = na % 1000000007;
            b = nb % 1000000007;
            c = nc % 1000000007;
            d = nd % 1000000007;
            e = ne % 1000000007;
            f = nf % 1000000007;
        }
        return (a + b + c + d + e + f) % 1000000007;
    }
};