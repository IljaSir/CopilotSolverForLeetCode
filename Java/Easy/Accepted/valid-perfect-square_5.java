class Solution {
    public boolean isPerfectSquare(int num) {
        
        if (num == 1) return true;
        int left = 1, right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == num / mid) {
                if (mid * mid == num) return true;
                else left = mid + 1;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}