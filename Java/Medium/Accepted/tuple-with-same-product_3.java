class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        for (int product : map.keySet()) {
            int count = map.get(product);
            ans += count * (count - 1) * 4;
        }
        return ans;
    }
}