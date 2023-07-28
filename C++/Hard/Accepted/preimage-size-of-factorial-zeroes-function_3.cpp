class Solution {
public:
    int preimageSizeFZF(int k) {
        
        long long l = 0, r = 1e18;
        int cnt = 0;
        while (l <= r) {
            long long mid = l + (r - l) / 2;
            long long t = mid / 5;
            long long c = 0;
            while (t) {
                c += t;
                t /= 5;
            }
            if (c == k) {
                return 5;
            }
            if (c > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
};