class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 5LL * (k + 1);
        while (l < r) {
            long long m = l + (r - l) / 2;
            if (trailingZeros(m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return trailingZeros(l) == k ? 5 : 0;
    }
};