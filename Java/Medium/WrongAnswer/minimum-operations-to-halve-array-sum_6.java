class Solution {
    public int halveArray(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int half = sum / 2;
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            res++;
            if (sum <= half) {
                break;
            }
        }
        return res;
    }
}