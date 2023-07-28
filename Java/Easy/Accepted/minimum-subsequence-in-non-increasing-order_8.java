class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        int total = 0;
        for (int num: nums) {
            total += num;
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sum += nums[i];
            if (sum > total - sum) {
                break;
            }
        }
        return ans;
    }
}