class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int complement = k - num;
            if (map.containsKey(complement) && map.get(complement) > 0) {
                map.put(complement, map.get(complement) - 1);
                map.put(num, map.get(num) - 1);
                count++;
            }
        }
        return count / 2;
    }
}