class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistribute(quantities, mid, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistribute(int[] quantities, int x, int n) {
        int sum = 0;
        for (int quantity : quantities) {
            sum += (quantity + x - 1) / x;
        }
        return sum <= n;
    }
}