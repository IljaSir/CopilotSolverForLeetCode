class Solution {
    public int countKDifference(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            if (map.containsKey(n - k)) {
                count += map.get(n - k);
            }
            if (map.containsKey(n + k)) {
                count += map.get(n + k);
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return count;
    }
}