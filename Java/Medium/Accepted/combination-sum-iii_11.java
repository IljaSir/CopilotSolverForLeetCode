class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum3Helper(k, n, 1, temp, result);
        return result;
    }

    public void combinationSum3Helper(int k, int n, int start, List<Integer> temp, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (k == 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            combinationSum3Helper(k - 1, n - i, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}