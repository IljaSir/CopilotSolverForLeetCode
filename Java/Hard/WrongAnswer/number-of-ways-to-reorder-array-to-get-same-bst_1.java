class Solution {
    public int numOfWays(int[] nums) {
        
        return (int) (helper(nums, 0, nums.length - 1) - 1);
    }

    private long helper(int[] nums, int start, int end) {
        if (start >= end) return 1;

        int root = nums[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < root) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int leftSize = left - start - 1;
        int rightSize = end - left + 1;

        return (helper(nums, start + 1, left - 1) * helper(nums, left, end) * (leftSize + rightSize + 1)) % 1_000_000_007;
    }
}