class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            cur += nums[i];
            res.add(nums[i]);
            if (cur > sum - cur) {
                break;
            }
        }
        return res;
    }
}