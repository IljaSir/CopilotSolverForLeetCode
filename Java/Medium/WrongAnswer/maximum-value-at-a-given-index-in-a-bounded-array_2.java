class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int left = 1;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (check(n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int n, int index, int maxSum, int x) {
        long sum = (long) x;
        int left = index;
        int right = index;
        int leftValue = x - 1;
        int rightValue = x - 1;
        while (left > 0 || right < n - 1) {
            if (left == 0) {
                rightValue = Math.min(rightValue, x - (n - 1 - right));
                sum += rightValue;
                right++;
                continue;
            }
            if (right == n - 1) {
                leftValue = Math.min(leftValue, x - left);
                sum += leftValue;
                left--;
                continue;
            }
            if (leftValue > rightValue) {
                leftValue = Math.min(leftValue, x - left);
                sum += leftValue;
                left--;
            } else {
                rightValue = Math.min(rightValue, x - (n - 1 - right));
                sum += rightValue;
                right++;
            }
        }
        return sum <= maxSum;
    }
}