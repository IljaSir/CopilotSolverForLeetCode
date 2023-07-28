class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long result = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (l == r) {
                result += nums[l];
                break;
            }
            result += (long) nums[l] * (long) Math.pow(10, (int) Math.log10(nums[r]) + 1) + nums[r];
            l++;
            r--;
        }
        return result;
    }
}