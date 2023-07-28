class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int start = 0, end = nums.length - 1;
        while (start < nums.length && nums[start] == sorted[start]) {
            start++;
        }
        while (end >= 0 && nums[end] == sorted[end]) {
            end--;
        }
        return Math.max(0, end - start + 1);
    }
}