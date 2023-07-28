class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int[] arr = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            arr[0] += i * nums[i];
        }
        int max = arr[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + sum - nums.length * nums[nums.length - i];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}