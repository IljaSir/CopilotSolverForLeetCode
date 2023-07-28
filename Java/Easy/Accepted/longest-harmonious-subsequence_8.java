class Solution {
    public int findLHS(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (map.containsKey(key - 1)) {
                max = Math.max(max, value + map.get(key - 1));
            }
        }
        return max;
    }
}