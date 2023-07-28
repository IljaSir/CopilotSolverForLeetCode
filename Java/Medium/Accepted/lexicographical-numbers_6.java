class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    public void dfs(int i, int n, List<Integer> result) {
        if (i > n) return;
        result.add(i);
        for (int j = 0; j < 10; j++) {
            dfs(i * 10 + j, n, result);
        }
    }
}