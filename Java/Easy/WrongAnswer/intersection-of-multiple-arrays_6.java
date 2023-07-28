class Solution {
    public List<Integer> intersection(int[][] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || nums[0].length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j], map.getOrDefault(nums[i][j], 0) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == nums.length) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}