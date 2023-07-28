class Solution {
    public int minDays(int n) {
        
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        return minDays(n, memo);
    }
    private int minDays(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int min = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            min = Math.min(min, minDays(n / 2, memo));
        }
        if (n % 3 == 0) {
            min = Math.min(min, minDays(n / 3, memo));
        }
        min = Math.min(min, minDays(n - 1, memo));
        memo.put(n, min + 1);
        return min + 1;
    }
}