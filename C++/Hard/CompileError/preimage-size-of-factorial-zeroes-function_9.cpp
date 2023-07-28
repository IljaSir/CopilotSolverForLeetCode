class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = (long long)k * 5;
        while (l < r) {
            long long m = l + (r - l) / 2;
            if (trailingZeroes(m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return trailingZeroes(l) == k ? 5 : 0;
    }
};