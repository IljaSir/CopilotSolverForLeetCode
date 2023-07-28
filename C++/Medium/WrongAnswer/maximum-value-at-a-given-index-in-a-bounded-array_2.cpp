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
        for (int i = 1; i < n; ++i) {
            if (l > 0 && r < n - 1) {
                if (mid - 1 > mid - (sum + mid - 1 - maxSum)) {
                    --l;
                    sum += mid - 1;
                } else {
                    ++r;
                    sum += mid - (sum + mid - 1 - maxSum);
                }
            } else if (l > 0) {
                --l;
                sum += mid - 1;
            } else if (r < n - 1) {
                ++r;
                sum += mid - (sum + mid - 1 - maxSum);
            } else break;
        }
        return sum <= maxSum;
    }
};