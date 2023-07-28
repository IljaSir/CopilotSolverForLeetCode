class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, nums, 0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                dfs(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}