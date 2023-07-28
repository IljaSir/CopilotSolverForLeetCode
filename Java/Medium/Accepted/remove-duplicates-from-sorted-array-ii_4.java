class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length <= 2) return nums.length;
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}