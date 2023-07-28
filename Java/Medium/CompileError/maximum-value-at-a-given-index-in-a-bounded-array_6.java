class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int l = 0;
        int r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(n, index, maxSum, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}