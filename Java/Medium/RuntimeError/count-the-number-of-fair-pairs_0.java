class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[] cnt = new int[upper - lower + 1];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];
                if (sum >= lower && sum <= upper) {
                    ans++;
                }
            }
            cnt[prefix[i + 1] - lower]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            ans += (long) cnt[i] * (cnt[i] - 1) / 2;
        }
        return ans;
    }
}