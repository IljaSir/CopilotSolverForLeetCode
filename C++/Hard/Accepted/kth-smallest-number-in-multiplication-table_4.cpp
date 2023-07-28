class Solution {
public:
    int findKthNumber(int m, int n, int k) {
        
        int lo = 1, hi = m * n + 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (enough(mi, m, n, k)) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
    bool enough(int mi, int m, int n, int k) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += min(mi / i, n);
        }
        return cnt >= k;
    }
};