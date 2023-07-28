class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = a - diff;
            int c = b - diff;
            if (map.containsKey(c) && map.containsKey(b)) {
                count += map.get(c) * map.get(b);
            }
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return count;
    }
}