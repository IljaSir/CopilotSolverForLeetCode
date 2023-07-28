class Solution {
    public int minDays(int n) {
        
        Map<Integer, Integer> dp = new HashMap<>();
        return dfs(n, dp);
    }
    
    private int dfs(int n, Map<Integer, Integer> dp) {
        if (n <= 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int result = 1 + dfs(n - 1, dp);
        if (n % 2 == 0) {
            result = Math.min(result, 1 + dfs(n / 2, dp));
        }
        if (n % 3 == 0) {
            result = Math.min(result, 1 + dfs(n / 3, dp));
        }
        dp.put(n, result);
        return result;
    }
}