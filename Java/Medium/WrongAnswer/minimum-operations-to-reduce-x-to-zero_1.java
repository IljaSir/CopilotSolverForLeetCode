class Solution {
    public int minOperations(int[] nums, int x) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        int target = prefix[n] - x;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int cur = prefix[i + 1];
            if (map.containsKey(cur - target)) {
                ans = Math.min(ans, i - map.get(cur - target));
            }
            map.put(cur, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : n - ans;
    }
}