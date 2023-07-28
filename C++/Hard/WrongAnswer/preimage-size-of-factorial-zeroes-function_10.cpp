class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 10e9, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (trailingZeroes(mid) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return trailingZeroes(l) == k ? 5 : 0;
    }
    int trailingZeroes(int n) {
        int res = 0;
        while (n) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
};