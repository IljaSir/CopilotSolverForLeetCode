class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int x: prefix) {
            ans += count.getOrDefault(x, 0);
            count.put(x + goal, count.getOrDefault(x + goal, 0) + 1);
        }
        return ans;
    }
}