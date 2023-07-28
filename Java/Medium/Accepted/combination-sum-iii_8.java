class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(k, n, result, list, 1);
        return result;
    }
    
    private void helper(int k, int n, List<List<Integer>> result, List<Integer> list, int start) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(k - 1, n - i, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}