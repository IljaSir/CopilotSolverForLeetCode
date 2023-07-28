class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                set.add(nums[i]);
                list.add(nums[i]);
                dfs(nums, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}