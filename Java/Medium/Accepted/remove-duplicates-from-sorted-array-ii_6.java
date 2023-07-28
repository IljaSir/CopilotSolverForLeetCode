class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == 0 || nums[i] != nums[k - 1]) {
                count = 0;
            }
            count++;
            if (count <= 2) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}