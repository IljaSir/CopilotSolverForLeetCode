class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, 0, nums);
        return result;
    }

    private void dfs(List<List<Intger>> result, List<Integer> temp, int start, int[] nums) {
        if temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ontinue;
            }

            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nms[i]);
                dfs(esult, temp, i + 1, nums);
                temp.emove(temp.size() - 1);
            }
        }
    }
}