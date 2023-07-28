class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        if (sum == 0) {
            return 0;
        }
        long cur = 0;
        int res = n;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            long need = (cur - sum + p) % p;
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
        }
        return res < n ? res : -1;
    }
}