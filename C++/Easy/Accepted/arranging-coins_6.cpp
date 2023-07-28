class Solution {
public:
    int arrangeCoins(int n) {
        
        int64_t l = 1, r = n, m;
        while (l <= r) {
            m = l + (r - l) / 2;
            int64_t s = m * (m + 1) / 2;
            if (s == n) return m;
            else if (s < n) l = m + 1;
            else r = m - 1;
        }
        return r;
    }
};