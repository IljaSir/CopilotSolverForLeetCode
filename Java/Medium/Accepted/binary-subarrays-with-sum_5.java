class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            int key = prefix[i] - goal;
            if (map.containsKey(key)) {
                result += map.get(key);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return result;
    }
}