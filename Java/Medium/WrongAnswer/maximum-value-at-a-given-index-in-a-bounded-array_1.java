class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        maxSum -= n;
        int left = 0;
        int right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (check(mid, index, n, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }

    boolean check(int x, int index, int n, int maxSum) {
        long sum = x;
        int l = index - 1;
        int r = index + 1;
        int left = x - 1;
        int right = x - 1;
        while (l >= 0 || r < n) {
            if (l >= 0) {
                sum += Math.min(left, maxSum);
                maxSum -= Math.min(left, maxSum);
                left--;
                l--;
            }
            if (r < n) {
                sum += Math.min(right, maxSum);
                maxSum -= Math.min(right, maxSum);
                right--;
                r++;
            }
        }
        return sum <= maxSum;
    }
}