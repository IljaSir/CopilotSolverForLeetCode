class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int half = sum / 2;
        sum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            sum += nums[i];
            if (sum > half) {
                break;
            }
        }
        return result;
    }
}