class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(result, current, 1, n, k);
        return result;
    }
    
    private void backTrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backTrack(result, current, i+1, n, k);
            current.remove(current.size()-1);
        }
    }
}