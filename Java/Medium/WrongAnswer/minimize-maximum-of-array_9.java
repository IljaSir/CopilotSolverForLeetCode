class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int n = nums.length;
        int max = sum / (n - 1);
        int rem = sum % (n - 1);
        if(rem == 0) {
            return max;
        } else {
            return max + 1;
        }
    }
}