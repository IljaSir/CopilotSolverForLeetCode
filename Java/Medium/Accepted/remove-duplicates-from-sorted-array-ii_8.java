class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 0;
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[k++] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    nums[k++] = nums[i];
                    count++;
                }
            }
        }
        return k;
    }
}