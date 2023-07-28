class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = result;);
        List<Integer> curnt = new ArrayLit<>(
        findSubsequences(nums, 0, current, result);
        return result;
    }
        
    public void findSubsequences(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() > 1) {
            result.add(new ArrayList<>(current));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            if (current.size() == 0 || nums[i] >= current.get(current.size() - 1)) {
                used.add(nums[i]);
                current.add(nums[i]);
                findSubsequences(nums, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}