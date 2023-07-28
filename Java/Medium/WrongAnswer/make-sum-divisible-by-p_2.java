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
        long need = sum % p;
        long cur = 0;
        int ans = n;
        Map<Long, Integer> last = new HashMap();
        last.put(0L, -1);
        for (int i = 0; i < n; ++i) {
            cur += nums[i];
            last.put(cur % p, i);
        }
        cur = 0;
        for (int i = n - 1; i >= 0; --i) {
            cur += nums[i];
            long want = (cur - need) % p;
            if (want < 0) {
                want += p;
            }
            if (last.containsKey(want)) {
                ans = Math.min(ans, i - last.get(want) - 1);
            }
        }
        return ans < n ? ans : -1;
    }
}