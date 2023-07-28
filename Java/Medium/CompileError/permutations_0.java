class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }
    
    public void permute(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> li = new ArrayList<>();
            for (int num : nums) {
                li.add(num);
            }
            result.add(li);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permute(nums, i + 1, result);
                swap(nums, i, j);
            }
        }
    }
}