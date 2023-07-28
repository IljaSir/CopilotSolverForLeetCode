class Solution {
    public int minOperations(int[] nums, int x) {
        
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            sum += nums[i];
            while (sum > x && j <= i) {
                sum -= nums[j];
                j++;
            }
            if (sum == x) {
                result = Math.min(result, n - i + j - 1);
            }
            i++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}