class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums[0].length; i++) {
            map.put(nums[0][i], 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (map.containsKey(nums[i][j])) {
                    map.put(nums[i][j], map.get(nums[i][j]) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}