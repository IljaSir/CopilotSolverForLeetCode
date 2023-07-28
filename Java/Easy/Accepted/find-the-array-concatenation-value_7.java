class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            ans += Long.parseLong("" + nums[i++] + nums[j--]);
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }
}