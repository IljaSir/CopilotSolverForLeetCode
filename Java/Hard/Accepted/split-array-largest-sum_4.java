class Solution {
    public int splitArray(int[] nums, int k) {
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }
        while (start < end) {
            int mid = (start + end) / 2;
            if (isValid(nums, k, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    
    private boolean isValid(int[] nums, int k, int max) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                count++;
                sum = nums[i];
            }
        }
        return count <= k;
    }
}