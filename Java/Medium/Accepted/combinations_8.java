class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(n < 1 || k < 1) return result;
        List<Integer> current = new ArrayList<>();
        combine(result, current, n, k, 1);
        return result;
    }
    public void combine(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if(k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start; i <= n; i++) {
            current.add(i);
            combine(result, current, n, k - 1, i + 1);
            current.remove(current.size() - 1);
        }
    }
}