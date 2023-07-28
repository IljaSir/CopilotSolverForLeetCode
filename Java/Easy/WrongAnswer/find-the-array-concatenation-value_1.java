class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long result = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                result = result * 10 + nums[l];
            } else {
                result = result * 100 + nums[l] * 10 + nums[r];
            }
            l++;
            r--;
        }
        return result;
    }
}