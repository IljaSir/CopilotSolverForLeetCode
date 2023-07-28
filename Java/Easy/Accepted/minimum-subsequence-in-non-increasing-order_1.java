class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int curSum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            curSum += nums[i];
            res.add(nums[i]);
            if (curSum > sum - curSum) {
                break;
            }
        }
        return res;
    }
}