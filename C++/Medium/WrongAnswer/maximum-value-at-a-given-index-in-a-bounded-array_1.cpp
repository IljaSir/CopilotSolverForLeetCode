class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(n, index, maxSum, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    bool check(int n, int index, int maxSum, int mid) {
        long long sum = mid;
        int l = index, r = index;
        while (l > 0 || r < n - 1) {
            int nl = l - 1, nr = r + 1;
            if (nl < 0 || nr >= n) break;
            if (mid - 1 > mid - nl - 1) {
                sum += mid - 1;
                mid = mid - 1;
                r = nr;
            }
            else {
                sum += mid - nl - 1;
                mid = mid - nl - 1;
                l = nl;
            }
        }
        if (l > 0) {
            int len = l;
            sum += (long long)mid * (len + 1) - (long long)len * (len + 1) / 2;
        }
        if (r < n - 1) {
            int len = n - 1 - r;
            sum += (long long)mid * (len + 1) - (long long)len * (len + 1) / 2;
        }
        return sum <= maxSum;
    }
};