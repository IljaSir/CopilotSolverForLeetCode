class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long mod = sum % p;
        if (mod == 0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long cur = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            if (map.containsKey((cur - mod + p) % p)) {
                ans = Math.min(ans, i - map.get((cur - mod + p) % p));
            }
        }
        return ans == n ? -1 : ans;
    }
}