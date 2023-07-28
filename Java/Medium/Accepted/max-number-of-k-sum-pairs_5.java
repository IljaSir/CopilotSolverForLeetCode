class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int diff = k - i;
            if (map.containsKey(diff) && map.get(diff) > 0) {
                count++;
                map.put(diff, map.get(diff) - 1);
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return count;
    }
}