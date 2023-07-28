class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int s = 0;
        for (int i = 0; i < n; ++i) {
            s += nums[i];
        }
        int t = s - x;
        if (t < 0) {
            return -1;
        }
        if (t == 0) {
            return n;
        }
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            m.put(sum, i);
            if (m.containsKey(sum - t)) {
                ans = Math.max(ans, i - m.get(sum - t));
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : n - ans;
    }
}