class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        int[] diff = new int[2 * n + 1];
        Arrays.fill(diff, -2);
        diff[n] = -1;
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (diff[sum + n] >= -1) {
                ans = Math.max(ans, i - diff[sum + n]);
            } else {
                diff[sum + n] = i;
            }
        }
        return ans;
    }
}