class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, visited);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(res, list, nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}