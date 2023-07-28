class Solution {
    public void nextPermutation(int[] nums) {
        
        int i = nums.length - 2;
        // Find the first decreasing number from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // If the number is found, we need to find the next bigger number
        // to swap with the current number
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Swap the number
            swap(nums, i, j);
        }
        // Reverse the rest of the array
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}