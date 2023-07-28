class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] num : nums) {
            for (int i : num) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == nums.length) {
                result.add(key);
            }
        }
        return result;
    }
}