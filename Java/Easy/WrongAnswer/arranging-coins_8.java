class Solution {
    public int arrangeCoins(int n) {
        
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * (mid + 1) / 2 <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}