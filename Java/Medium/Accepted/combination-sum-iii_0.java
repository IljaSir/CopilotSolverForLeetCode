class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }
    private void combinationSum3(int k, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            combinationSum3(k - 1, n - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}