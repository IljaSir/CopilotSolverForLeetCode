class Solution {
    public boolean isPerfectSquare(int num) {
        
        if (num == 1) return true;
        int left = 0;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == num / mid) {
                return num % mid == 0;
            } else if (mid < num / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}