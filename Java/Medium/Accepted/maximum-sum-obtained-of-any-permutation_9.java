class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length, mod = 1000000007;
        int[] cnt = new int[n];
        for (int[] r : requests) {
            cnt[r[0]]++;
            if (r[1] + 1 < n) cnt[r[1] + 1]--;
        }
        for (int i = 1; i < n; i++) cnt[i] += cnt[i - 1];
        Arrays.sort(cnt);
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < n; i++) res = (res + (long) cnt[i] * nums[i]) % mod;
        return (int) res;
    }
}