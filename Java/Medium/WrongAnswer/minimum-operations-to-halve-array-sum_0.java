class Solution {
    public int halveArray(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            count++;
            if (sum < nums[i]) {
                break;
            }
        }
        return count;
    }
}