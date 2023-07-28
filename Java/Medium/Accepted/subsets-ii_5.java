class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            dfs(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}