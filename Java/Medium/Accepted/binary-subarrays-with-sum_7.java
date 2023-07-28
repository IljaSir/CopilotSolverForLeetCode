class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int cur = pre[i];
            res += map.getOrDefault(cur, 0);
            map.put(cur + goal, map.getOrDefault(cur + goal, 0) + 1);
        }
        return res;
    }
}