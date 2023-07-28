class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        Arrays.sort(nums);
        int currentSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.add(nums[i]);
            if (currentSum > sum - currentSum) {
                break;
            }
        }
        return result;
    }
}