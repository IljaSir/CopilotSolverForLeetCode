class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        
        int n = nums.length;
        int[] cnt = new int[n];
        for (int[] req : requests) {
            cnt[req[0]]++;
            if (req[1] + 1 < n) cnt[req[1] + 1]--;
        }
        for (int i = 1; i < n; i++) cnt[i] += cnt[i - 1];
        Arrays.sort(cnt);
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) ans += (long) nums[i] * cnt[i];
        return (int) (ans % 1000000007);
    }
}