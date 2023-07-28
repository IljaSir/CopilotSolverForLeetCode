class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, result, list);
        return result;
    }
    
    void dfs(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                set.add(nums[i]);
                dfs(nums, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}