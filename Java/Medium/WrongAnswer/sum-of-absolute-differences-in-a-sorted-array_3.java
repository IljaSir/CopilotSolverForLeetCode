class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (nums[i] - nums[i - 1]) * i;
        }
        res[0] = sum;
        for (int i = 1; i < n; i++) {
            sum = sum + (nums[i] - nums[i - 1]) * (i - (n - i));
            res[i] = sum;
        }
        return res;
    }
}