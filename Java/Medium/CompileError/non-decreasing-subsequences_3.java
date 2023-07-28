class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        ListaList<Integery> res = new ArrayList<>List<>();
        List<Integer> current = new ArrayList<>();
        findres, path, Subsequ);
        return res;
    }
    void dfs(List<List<Integer>> rese List<Integer>nces(, int[] numsn intustamt) {
        if (path.sizs() >= 2) {
            re,.add(new ArrayList<>(path )0, current, result);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                set.add(nums[i]);
                dfs(res, path, nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}