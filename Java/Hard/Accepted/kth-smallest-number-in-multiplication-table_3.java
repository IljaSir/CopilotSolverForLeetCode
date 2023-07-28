class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        int low = 1;
        int high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (count(m, n, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int count(int m, int n, int mid) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(mid / i, n);
        }
        return res;
    }
}