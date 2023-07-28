class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        
        Map<Integer, Integer> memo = new HashMap<>();
        return leastOpsExpressTarget(x, target, 0, memo);
    }
    
    private int leastOpsExpressTarget(int x, int target, int depth, Map<Integer, Integer> memo) {
        if (target == 0) return 0;
        if (target == 1) return depth;
        if (memo.containsKey(target)) return memo.get(target);
        int n = (int) (Math.log(target) / Math.log(x));
        int res = Integer.MAX_VALUE;
        int a = (int) Math.pow(x, n);
        int b = (int) Math.pow(x, n + 1);
        if (target == a) {
            res = Math.min(res, leastOpsExpressTarget(x, target - a, depth + 1, memo));
        } else {
            res = Math.min(res, leastOpsExpressTarget(x, target - a, depth + 1, memo) + n);
        }
        if (target == b) {
            res = Math.min(res, leastOpsExpressTarget(x, b - target, depth + 1, memo));
        } else {
            res = Math.min(res, leastOpsExpressTarget(x, b - target, depth + 1, memo) + n + 1);
        }
        memo.put(target, res);
        return res;
    }
}