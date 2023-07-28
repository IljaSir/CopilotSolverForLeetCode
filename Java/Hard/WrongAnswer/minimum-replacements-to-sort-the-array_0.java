class Solution {
    public long minimumReplacement(int[] nums) {
        
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] /= 2;
                i--;
            } else {
                res++;
            }
        }
        return res;
    }
}