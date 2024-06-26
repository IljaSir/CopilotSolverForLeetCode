class Solution {
    public int findLHS(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        for (int n : map.keySet()) {
            if (map.containsKey(n + 1)) {
                res = Math.max(res, map.get(n) + map.get(n + 1));
            }
        }
        return res;
    }
}