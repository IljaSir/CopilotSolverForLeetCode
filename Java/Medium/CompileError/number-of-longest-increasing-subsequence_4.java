class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
         
        return res;
    }
}