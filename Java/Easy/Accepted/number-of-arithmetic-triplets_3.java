class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - diff) && map.containsKey(nums[i] - 2 * diff)) {
                count += map.get(nums[i] - diff) * map.get(nums[i] - 2 * diff);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}