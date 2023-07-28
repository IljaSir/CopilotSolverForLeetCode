class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            dfs(res, n, k, i, i);
        }
        if (n == 1) {
            res.add(0);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private void dfs(List<Integer> res, int n, int k, int num, int last) {
        if (n == 0) {
            res.add(num);
            return;
        }
        int next = last + k;
        if (next <= 9) {
            dfs(res, n - 1, k, num * 10 + next, next);
        }
        next = last - k;
        if (next >= 0 && k != 0) {
            dfs(res, n - 1, k, num * 10 + next, next);
        }
    }
}