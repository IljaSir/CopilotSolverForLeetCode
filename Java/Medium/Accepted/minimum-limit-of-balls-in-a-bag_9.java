class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int low = 1;
        int high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private boolean canDivide(int[] nums, int maxOperations, int threshold) {
        for (int num : nums) {
            maxOperations -= (num - 1) / threshold;
            if (maxOperations < 0) {
                return false;
            }
        }
        return true;
    }
}