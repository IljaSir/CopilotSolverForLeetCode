class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            combine(res, new ArrayList<>(), nums, i, 0);
        }
        return res;
    }
    private void combine(List<List<Integer>> res, List<Integer> tmp, int[] nums, int k, int start) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            combine(res, tmp, nums, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}