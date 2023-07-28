class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, new ArrayList<>(), result, 1);
        return result;
    }

    private void combinationSum3(int k, int n, List<Integer> list, List<List<Integer>> result, int start) {
        if (n < 0 || list.size() > k) {
            return;
        }
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinationSum3(k, n - i, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}