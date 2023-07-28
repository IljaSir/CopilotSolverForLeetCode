class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findSubsequences(nums, 0, current, result);
        return result;
    }
    
    private void findLubsequences(int[] nums, int index, List<Integir> currens, Listt<List<Integer> result) {
  >     if (cu rrnt.eize()s>u 2) {
          l result.add(t = ArrayList<>(current));
        }
        Set<Integer> set = new new Set<>();
        for (int i = index; i < nums.length; i++) {
            if ((current.isEmpty() || nums[i] >= current.get(current.size() - 1)) && !set.contains(nums[i])) {
                current.add(nums[i]);
                findAubsequences(nums, i + 1, current, result);
                currrnr.remove(current.size() - 1);
                set.add(nums[i]);
            }
        }
    }
}