class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int target = k - num;
            if (map.containsKey(target) && map.get(target) > 0) {
                map.put(target, map.get(target) - 1);
                result++;
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }
}