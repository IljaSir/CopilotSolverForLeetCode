class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        
        int l = 1, r = maxSum, m;
        while (l < r) {
            m = l + (r - l + 1) / 2;
            if (check(n, index, maxSum, m)) l = m;
            else r = m - 1;
        }
        return l;
    }
    bool check(int n, int index, int maxSum, int x) {
        long long l = 0, r = 0;
        int i = index;
        while (i >= 0 && x - i <= x) {
            l += min(x, x - i);
            i--;
        }
        i = index + 1;
        while (i < n && x - (n - i - 1) <= x) {
            r += min(x, x - (n - i - 1));
            i++;
        }
        return l + r + x <= maxSum;
    }
};