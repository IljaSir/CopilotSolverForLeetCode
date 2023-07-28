class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long mod = sum % p;
        if (mod == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        long cur = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            long remain = cur % p;
            long target = (remain - mod + p) % p;
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }
            map.put(remain, i);
        }
        return ans == n ? -1 : ans;
    }
}