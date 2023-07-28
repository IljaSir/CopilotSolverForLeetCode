class Solution {
    public int arrayNesting(int[] nums) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; nums[j] != -1; count++) {
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}