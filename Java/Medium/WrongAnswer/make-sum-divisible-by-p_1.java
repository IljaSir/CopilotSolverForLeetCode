class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % p == 0) {
            return 0;
        }
        long mod = sum % p;
        long target = sum - mod;
        long cur = 0;
        int ans = n;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            if (map.containsKey(cur - target)) {
                ans = Math.min(ans, i - map.get(cur - target));
            }
            map.put(cur, i);
        }
        return ans == n ? -1 : ans;
    }
}