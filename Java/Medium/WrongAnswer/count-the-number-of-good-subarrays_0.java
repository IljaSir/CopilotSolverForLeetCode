class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += map.getOrDefault(sum[i] - k, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 7];
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
        return (int)ans;
    }
}