class Solution {
public:
    int findKthNumber(int m, int n, int k) {
        
        int lo = 1;
        int hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                cnt += min(mid / i, n);
            }
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
};