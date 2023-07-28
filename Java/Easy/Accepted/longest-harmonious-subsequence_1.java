class Solution {
    public int findLHS(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        for (int n : map.keySet()) {
            if (map.containsKey(n + 1)) {
                max = Math.max(max, map.get(n) + map.get(n + 1));
            }
        }
        return max;
    }
}