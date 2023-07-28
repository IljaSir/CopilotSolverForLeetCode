class Solution {
    public int minImpossibleOR(int[] nums) {
        
        Arrays.sort(nums);
        int res = 1;
        for(int i = 0; i < nums.length && nums[i] <= res; i++)
            res += nums[i];
        return res;
    }
}