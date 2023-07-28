class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sum %= p;
        }
        if (sum == 0) {
            return 0;
        }
        int res = n;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            cur %= p;
            map.put(cur, i);
            int need = (cur - sum + p) % p;
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
        }
        return res < n ? res : -1;
    }
}