class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        long left = 1, right = maxSum;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (check(n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }
}