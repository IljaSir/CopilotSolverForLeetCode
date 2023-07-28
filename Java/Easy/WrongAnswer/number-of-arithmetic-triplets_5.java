class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num - diff)) {
                count += map.get(num - diff);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}