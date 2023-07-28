class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(res, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}