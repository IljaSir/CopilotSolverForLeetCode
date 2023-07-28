class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        St<List<Iteger>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, res, list);
        return new ArrayList<>(res);
    }
    
    private void helper(int[] nums, int start, Set<List<Integer>> res, List<Integer> list) {
        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                helper(nums, i + 1, res, list);
                list.remove(lis
    }
}