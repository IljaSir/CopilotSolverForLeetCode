class Solution {
    public int maximumSum(int[] nums) {
        
        int ans = -1;
        int[] sum = new int[91];
        Arrays.fill(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int s = 0;
            while (a > 0) {
                s += a % 10;
                a /= 10;
            }
            if (sum[s] != -1) {
                ans = Math.max(ans, sum[s] + nums[i]);
            }
            sum[s] = Math.max(sum[s], nums[i]);
        }
        return ans;
    }
}