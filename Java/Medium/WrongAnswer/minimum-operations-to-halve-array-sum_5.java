class Solution {
    public int halveArray(int[] nums) {
        
        int sum = Arrays.stream(nums).sum();
        int target = (sum + 1) / 2;
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum -= nums[i];
            count++;
            if (sum < target) {
                return count;
            }
        }
        return count;
    }
}