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
        for (int i = mid - 1; i >= 1; i--) {
            if (l - 1 >= 0) {
                sum += i;
                l--;
            }
            else if (r + 1 < n) {
                sum += i;
                r++;
            }
            else break;
        }
        return sum <= maxSum;
    }
};