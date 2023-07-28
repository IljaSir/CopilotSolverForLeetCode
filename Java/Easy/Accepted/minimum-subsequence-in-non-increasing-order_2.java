class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int currentSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            result.add(nums[i]);
            if (currentSum > sum - currentSum) {
                return result;
            }
        }
        return result;
    }
}