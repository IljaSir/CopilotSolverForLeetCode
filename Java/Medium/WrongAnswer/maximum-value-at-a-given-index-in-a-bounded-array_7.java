class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (check(mid, n, index, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private boolean check(int x, int n, int index, int maxSum) {
        long sum = x;
        int l = index, r = index;
        while (l > 0 || r < n - 1) {
            l = Math.max(0, l - 1);
            r = Math.min(n - 1, r + 1);
            sum += x - Math.abs(index - l);
            sum += x - Math.abs(index - r);
            if (sum > maxSum) {
                return false;
            }
        }
        return sum <= maxSum;
    }
}