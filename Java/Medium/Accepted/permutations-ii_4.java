class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            helper(result, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}