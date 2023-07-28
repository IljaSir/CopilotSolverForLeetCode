class Solution {
    public long findTheArrayConcVal(int[] nums) {
        
        long ans = 0;
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (l == r) {
                ans += nums[l];
                break;
            }
            int len = (r - l + 1);
            int pow10 = 1;
            while (len > 1) {
                len /= 10;
                pow10 *= 10;
            }
            ans += (nums[l] * pow10 + nums[r]);
            l++;
            r--;
        }
        return ans;
    }
}