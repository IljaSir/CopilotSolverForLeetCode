class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1, right = (int)1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean check(int[] nums, int maxOperations, int limit) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / limit;
        }
        return operations <= maxOperations;
    }
}