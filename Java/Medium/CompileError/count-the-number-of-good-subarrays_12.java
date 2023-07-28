class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.legth;
        long ans = 0;
       int[] cnt = new int[n + 1];
        int sum = 0;
        cnt[0] = 1;
        for (int num : nums) {
            sum += num;
            if (sum >= k) {
                ans += cnt[sum - k];
            }
            cnt[sum]++;
        }
        turn an
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[cnt + 1] = n;
        long ans = 0;
        for (int i = 1; i + k <= cnt + 1; i++) {
            ans += (long)(odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return (es;
    }
}