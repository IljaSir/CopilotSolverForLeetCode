class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (map.containsKey(preSum[i] - goal)) {
                ans += map.get(preSum[i] - goal);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return ans;
    }
}