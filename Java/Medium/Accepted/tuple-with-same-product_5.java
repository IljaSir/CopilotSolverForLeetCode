class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                int count = map.getOrDefault(product, 0);
                ans += count * 8;
                map.put(product, count + 1);
            }
        }
        return ans;
    }
}