class Solution {
    public int tupleSameProduct(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int ans = 0;
        for (int key : map.keySet()) {
            ans += map.get(key) * (map.get(key) - 1) * 4;
        }
        return ans;
    }
}