class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int count = 0;
        for(int product : map.keySet()) {
            int freq = map.get(product);
            count += freq * (freq - 1);
        }
        return count * 8;
    }
}