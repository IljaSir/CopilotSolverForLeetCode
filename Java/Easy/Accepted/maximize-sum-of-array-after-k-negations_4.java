class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;
        while (i < nums.length && k > 0 && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
            k--;
        }
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
        }
        if (k % 2 == 1) {
            sum -= 2 * nums[0];
        }
        return sum;
    }
}