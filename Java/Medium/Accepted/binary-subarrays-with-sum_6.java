class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int x : pre) {
            ans += count.getOrDefault(x, 0);
            count.put(x + goal, count.getOrDefault(x + goal, 0) + 1);
        }
        return ans;
    }
}