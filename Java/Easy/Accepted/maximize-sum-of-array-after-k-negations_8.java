class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        
        int sum = 0;
        Arrays.sort(nums);
        int i = 0;
        while (k > 0 && i < nums.length && nums[i] < 0) {
            nums[i] *= -1;
            k--;
            i++;
        }
        if (k > 0) {
            Arrays.sort(nums);
            if (k % 2 == 1) {
                nums[0] *= -1;
            }
        }
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }
}