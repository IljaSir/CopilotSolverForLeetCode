class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}