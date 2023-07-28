class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % p;
        }
        if (sum == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long cur = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            long target = (cur - sum + p) % p;
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }
        }
        return ans < n ? ans : -1;
    }
}