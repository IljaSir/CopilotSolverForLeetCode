class Solution {
    public int halveArray(int[] nums) {
        
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int half = sum / 2;
        int count = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum -= nums[i];
            count += 1;
            if (sum <= half) {
                break;
            }
        }
        return count;
    }
}