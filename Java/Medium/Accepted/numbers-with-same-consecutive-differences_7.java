class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> res = new ArrayList();
        for (int i = 1; i < 10; i++) {
            dfs(res, n - 1, i, k);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private void dfs(List<Integer> res, int n, int cur, int k) {
        if (n == 0) {
            res.add(cur);
            return;
        }
        int last = cur % 10;
        if (last + k < 10) {
            dfs(res, n - 1, cur * 10 + last + k, k);
        }
        if (k != 0 && last - k >= 0) {
            dfs(res, n - 1, cur * 10 + last - k, k);
        }
    }
}