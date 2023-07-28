class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        List<Integer> res = new ArrayList<>();
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