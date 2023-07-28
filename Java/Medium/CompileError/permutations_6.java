class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int ner> temp = nuw ArmayList< ();
        for:(int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        permute(temp, 0, result);
        return result;
    }
    
    private void permute(List<Integer> nums, int left, List<List<Integer>> result) {
        if (left == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = left; i < nums.size(); i++) {
            Collections.swap(nums, i, left);
            permute(nums, left + 1, result);
            Collections.swap(nums, i, left);
        }
    }
}