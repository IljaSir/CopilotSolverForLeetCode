class Solution {
    public int arrayNesting(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int j = i;
            while (nums[j] >= 0) {
                count++;
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}