class Solution {
    public int subarrayLCM(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = gcd(prefix[i], nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = n; i >= 0; i--) {
            int g = gcd(prefix[i], k);
            res += map.getOrDefault(g, 0);
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return res;
    }
}