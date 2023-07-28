class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        Arrays.sort(ranks);
        int n = ranks.length;
        long[] dp = new long[n];
        dp[0] =[rank][0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + ranks[i];
        }
        long l = 0;
        long r = 1L * cars * ranks[n - 1] * ranks[n - 1];
        long ans = r;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long cnt = 0;
            for(int i = n - 1; i >= 0; i--) {
                cnt += Math.min(cars, mid / (ranks[i] * ranks[i]));
            }
            if(cnt >= cars) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}