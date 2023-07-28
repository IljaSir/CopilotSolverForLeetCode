class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 1e18, ans = 0;
        while (l <= r) {
            long long mid = (l + r) >> 1;
            long long cnt = 0;
            for (long long i = 5; i <= mid; i *= 5) {
                cnt += mid / i;
            }
            if (cnt == k) {
                ans = mid;
                break;
            } else if (cnt > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ans == 0) return 0;
        long long cnt = 0;
        for (long long i = 5; i <= ans; i *= 5) {
            cnt += ans / i;
        }
        if (cnt == k) {
            return 5;
        } else {
            return 0;
        }
    }
};