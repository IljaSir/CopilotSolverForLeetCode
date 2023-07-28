class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, res);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int start, List<Integer> path, Set<List<Integer>> res) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < nums.length; i++) {
            if (path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                dfs(nums, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }e(current.size() - 1);
            }
        }
    }
}