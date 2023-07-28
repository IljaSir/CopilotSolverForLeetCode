class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean check(int n, int[] quantities, int x) {
        long sum = 0;
        for (int i = 0; i < quantities.length; i++) {
            sum += (quantities[i] + x - 1) / x;
        }
        return sum <= n;
    }
}