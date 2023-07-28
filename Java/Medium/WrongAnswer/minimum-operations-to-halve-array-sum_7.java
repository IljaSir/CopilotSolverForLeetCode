class Solution {
    public int halveArray(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int half = sum / 2;
        int ops = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum <= half) {
                break;
            }
            sum -= nums[i];
            ops++;
        }
        return ops;
    }
}