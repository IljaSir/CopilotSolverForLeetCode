class Solution {
    public int tupleSameProduct(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int ans = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            ans += value * (value - 1) * 4;
        }
        return ans;
    }
}