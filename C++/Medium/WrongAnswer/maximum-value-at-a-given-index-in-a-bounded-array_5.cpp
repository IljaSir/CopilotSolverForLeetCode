class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(n, index, maxSum, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return check(n, index, maxSum, l) ? l : l - 1;
    }
    bool check(int n, int index, int maxSum, int x) {
        int sum = x;
        if (x > index + 1) {
            sum += (x - index - 1) * (x - index) / 2;
        } else {
            sum += (x - 1) * x / 2;
        }
        if (x > n - index) {
            sum += (x - n + index) * (x - n + index + 1) / 2;
        } else {
            sum += (x - 1) * x / 2;
        }
        if (x > n) {
            sum -= (x - n) * (x - n + 1) / 2;
        }
        return sum <= maxSum;
    }
};