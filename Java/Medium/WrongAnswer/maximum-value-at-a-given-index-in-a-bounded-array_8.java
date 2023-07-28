class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        long left = 1;
        long right = maxSum;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long sum = mid;
            if (index >= mid) {
                sum += (index + mid - 1) * mid / 2;
            } else {
                sum += (mid - 1) * mid / 2 + (mid - index);
            }
            if (n - index - 1 >= mid) {
                sum += (n - index - 1 + mid - 1) * mid / 2;
            } else {
                sum += (mid - 1) * mid / 2 + (mid - (n - index - 1));
            }
            if (sum <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }
}