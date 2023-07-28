class Solution {
    public int minDays(int n) {
        
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(n, memo);
    }
    
    private int dp(int n, Map<Integer, Integer> memo) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 1 + Math.min(n % 2 + dp(n / 2, memo), n % 3 + dp(n / 3, memo));
        memo.put(n, res);
        return res;
    }
}