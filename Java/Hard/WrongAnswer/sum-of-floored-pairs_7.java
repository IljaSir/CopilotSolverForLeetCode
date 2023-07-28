class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        
        int mod = (int)1e9 + 7;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] cnt = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int[] sum = new int[max + 1];
        sum[0] = cnt[0];
        for(int i = 1; i <= max; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        long ans = 0;
        for(int i = 1; i <= max; i++) {
            int j = 1;
            while(i * j <= max) {
                ans += (long)(sum[Math.min(max, i * j + i - 1)] - sum[i * j - 1]) * j;
                j++;
            }
        }
        return (int)(ans % mod);
    }
}