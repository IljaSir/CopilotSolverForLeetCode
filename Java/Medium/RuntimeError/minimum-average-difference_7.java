class Solution {
    public int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        int[][] ps = new int[n][2];
        ps[0][0] = nums[0];
        ps[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            ps[i][0] = ps[i - 1][0] + nums[i];
            ps[i][1] = ps[i - 1][1] + nums[n - i - 1];
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = ps[i][0] + ps[n - i - 1][1];
            int c = (i + 1) * (n - i - 1);
            int v = sum / c;
            int d = Math.abs(sum - v * c);
            if (d < min) {
                min = d;
                ans = i;
            }
        }
        return ans;
    }
}