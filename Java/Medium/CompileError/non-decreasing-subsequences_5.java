class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return new ArrayList<>(res);
    }

    private void findSubsequences(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if ((current.isEmpty() || nums[i] >= current.get(current.size() - 1)) && !set.contains(nums[i])) {
                current.add(nums[i]);
                findSubsequences(nums, i + 1, current, result);
                current.remove(current.size() - 1);
                set.add(nums[i]);
            }
        }
    }
}