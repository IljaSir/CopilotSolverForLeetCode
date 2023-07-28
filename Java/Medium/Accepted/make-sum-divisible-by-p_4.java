class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        if (sum == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long cur = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            long target = (cur - sum + p) % p;
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
        }
        return res < nums.length ? res : -1;
    }
}