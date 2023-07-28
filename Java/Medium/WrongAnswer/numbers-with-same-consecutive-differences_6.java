class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(res, i, n, k);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
    private void dfs(List<Integer> res, int num, int n, int k) {
        if (n == 0) {
            res.add(num);
            return;
        }
        int tail = num % 10;
        if (tail - k >= 0) {
            dfs(res, num * 10 + tail - k, n - 1, k);
        }
        if (tail + k <= 9 && k != 0) {
            dfs(res, num * 10 + tail + k, n - 1, k);
        }
    }
}