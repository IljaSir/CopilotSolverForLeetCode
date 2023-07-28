class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        long lo = 0, hi = maxSum;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long left = mid - 1 - Math.max(0, index - mid + 1);
            long right = mid - 1 - Math.max(0, n - index - mid);
            long sum = mid + left * (left + 1) / 2 + right * (right + 1) / 2;
            if (sum > maxSum) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo - 1;
    }
}