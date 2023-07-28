class Solution {
    public int lastRemaining(int n) {
        
        return helper(1, n, true);
    }
    private int helper(int left, int right, boolean isLeft) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (isLeft) {
            return helper(mid + 1, right, !isLeft);
        } else {
            return helper(left, mid, !isLeft);
        }
    }
}