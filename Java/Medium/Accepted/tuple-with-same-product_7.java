class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        for (int v : map.values()) {
            ans += v * (v - 1) * 4;
        }
        return ans;
    }
}