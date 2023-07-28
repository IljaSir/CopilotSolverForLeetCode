class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int count = 0;
        for (int key : map.keySet()) {
            int v = map.get(key);
            count += v * (v - 1) * 4;
        }
        return count;
    }
}