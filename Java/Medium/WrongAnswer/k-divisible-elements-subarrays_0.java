class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int n = nums.length;
        int[] mod = new int[n + 1];
        for (int i = 0; i < n; i++) {
            mod[i + 1] = (mod[i] + nums[i]) % p;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (i >= k) {
                map.put(mod[i - k], map.getOrDefault(mod[i - k], 0) - 1);
            }
            ans += map.getOrDefault(mod[i], 0);
            map.put(mod[i], map.getOrDefault(mod[i], 0) + 1);
        }
        return ans;
    }
}