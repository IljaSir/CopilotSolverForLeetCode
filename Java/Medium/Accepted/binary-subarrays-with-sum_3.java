class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            int p = prefix[i];
            res += map.getOrDefault(p, 0);
            map.put(p + goal, map.getOrDefault(p + goal, 0) + 1);
        }
        return res;
    }
}