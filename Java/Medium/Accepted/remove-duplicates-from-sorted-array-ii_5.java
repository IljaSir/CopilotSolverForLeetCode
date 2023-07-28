class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                if (count == 1) {
                    nums[++i] = nums[j++];
                    count++;
                } else {
                    j++;
                }
            } else {
                nums[++i] = nums[j++];
                count = 1;
            }
        }
        return i + 1;
    }
}