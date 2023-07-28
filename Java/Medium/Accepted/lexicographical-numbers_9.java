class Solution {
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i <= n) {
                result.add(i);
                dfs(i, n, result);
            }
        }
        return result;
    }

    public void dfs(int i, int n, List<Integer> result) {
        int start = i * 10;
        for (int j = 0; j < 10; j++) {
            int num = start + j;
            if (num <= n) {
                result.add(num);
                dfs(num, n, result);
            }
        }
    }
}