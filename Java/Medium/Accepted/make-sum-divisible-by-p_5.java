class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % p == 0) {
            return 0;
        }
        int target = (int) (sum % p);
        int ans = n;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            map.put(cur, i);
            int need = (cur - target + p) % p;
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }
        }
        return ans == n ? -1 : ans;
    }
}