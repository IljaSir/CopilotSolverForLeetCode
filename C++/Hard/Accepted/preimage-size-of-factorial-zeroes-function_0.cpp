class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 5LL * (k + 1);
        while (l < r) {
            long long m = l + (r - l) / 2;
            long long z = f(m);
            if (z < k) l = m + 1;
            else if (z > k) r = m;
            else return 5;
        }
        return 0;
    }
    long long f(long long x) {
        long long res = 0;
        while (x) {
            res += x / 5;
            x /= 5;
        }
        return res;
    }
};