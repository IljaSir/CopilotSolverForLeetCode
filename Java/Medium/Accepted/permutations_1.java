class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
    public void helper(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(nums, start + 1, res);
            swap(nums, i, start);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}