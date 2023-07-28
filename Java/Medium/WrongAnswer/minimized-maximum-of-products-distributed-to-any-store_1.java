class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int max = 0;
        for (int i = 0; i < quantities.length; i++) {
            max = Math.max(max, quantities[i]);
        }
        int l = 1, r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(mid, n, quantities)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean check(int x, int n, int[] quantities) {
        int sum = 0;
        for (int i = 0; i < quantities.length; i++) {
            sum += quantities[i] / x;
        }
        return sum >= n;
    }
}