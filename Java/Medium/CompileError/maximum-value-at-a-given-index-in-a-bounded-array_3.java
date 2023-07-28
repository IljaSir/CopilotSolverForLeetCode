class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int l = 1, r = maxSum;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (check(n, index, maxSum, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}