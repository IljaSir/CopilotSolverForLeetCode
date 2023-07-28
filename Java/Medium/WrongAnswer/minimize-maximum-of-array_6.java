class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int m = sum / (n - 1);
        if (sum % (n - 1) != 0) {
            m++;
        }
        return m;
    }
}