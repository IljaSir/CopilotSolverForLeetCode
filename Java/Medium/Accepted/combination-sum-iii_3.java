class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> list, int k, int n, int start) {
        if (list.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(result, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}