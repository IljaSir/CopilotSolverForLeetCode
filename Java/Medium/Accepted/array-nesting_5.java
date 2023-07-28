class Solution {
    public int arrayNesting(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int count = 0;
                int j = i;
                while (nums[j] != Integer.MAX_VALUE) {
                    int temp = nums[j];
                    nums[j] = Integer.MAX_VALUE;
                    j = temp;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}