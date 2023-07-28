class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), result, visited);
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result, boolean[] visited) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums, permutation, result, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}