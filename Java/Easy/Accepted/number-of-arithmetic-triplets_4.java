class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result += map.getOrDefault(nums[i] - diff, 0) * map.getOrDefault(nums[i] - 2 * diff, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return result;
    }
}