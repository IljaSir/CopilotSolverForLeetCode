class Solution {
    public int minDays(int n) {
        
        if (n <= 1) {
            return n;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }
    
    private int dfs(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 1 + Math.min(n % 2 + dfs(n / 2, memo), n % 3 + dfs(n / 3, memo));
        memo.put(n, res);
        return res;
    }
}