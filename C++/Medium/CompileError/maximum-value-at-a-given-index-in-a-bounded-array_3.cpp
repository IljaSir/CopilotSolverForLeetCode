class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        
        maxSum -= n;
        int l = 0, r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid, n, index, maxSum)) l = mid;
            else r = mid - 1;
        }
        return l + 1;
    }
};