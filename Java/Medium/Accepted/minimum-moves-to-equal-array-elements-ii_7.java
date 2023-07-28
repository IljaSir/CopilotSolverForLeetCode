class Solution {
    public int minMoves2(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int median = nums[n / 2];
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(nums[i] - median);
        }
        return result;
    }
}