class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int[] result = new int[2];
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                result[0] = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        result[1] = sum + result[0];
        return result;
    }
}