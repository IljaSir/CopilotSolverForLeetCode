class Solution {
    public long countPairs(int[] nums, int k) {
        
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int mod = nums[i] % k;
            if (mod < 0) {
                mod += k;
            }
            ans += map.getOrDefault((k - mod) % k, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return ans;
    }
}