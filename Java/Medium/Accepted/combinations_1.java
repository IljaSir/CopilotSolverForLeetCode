class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void combine(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            combine(result, current, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }
}