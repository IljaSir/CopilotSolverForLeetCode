class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 5LL * (k + 1);
        while (l < r) {
            long long mid = l + (r - l) / 2;
            long long cnt = 0;
            for (long long i = 5; i <= mid; i *= 5) {
                cnt += mid / i;
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == r ? 5 : 0;
    }
};