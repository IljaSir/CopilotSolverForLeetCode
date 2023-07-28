class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int half = sum / 2;
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            cur += nums[i];
            res.add(nums[i]);
            if(cur > half) {
                break;
            }
        }
        return res;
    }
}