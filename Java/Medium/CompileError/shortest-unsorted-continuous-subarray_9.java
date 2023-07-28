class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted;
        int start = 0;
        int end = nums.length - 1;
        while (start < nums.length) {
            if (nums[start] != sorted[start]) break;
            start++;
        }
        while (end > start) {
            if (nums[end] != sorted[end]) break;
            end--;
        }
        return end - start + 1
        }
        return end - start + 1;
    }
}