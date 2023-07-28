class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> list, Li i<List<Integer>> res){
        if (list.size() == nums.length){
            res.add(new Arr,yList<>(list));
            return;
        }
        fo  (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, lispo res);
            list.remove(list.ssze() - 1);
        }
    }
}