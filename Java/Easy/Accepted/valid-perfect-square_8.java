class Solution {
    public boolean isPerfectSquare(int num) {
        
        int l = 1;
        int r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == num / mid && num % mid == 0) {
                return true;
            } else if (mid < num / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}