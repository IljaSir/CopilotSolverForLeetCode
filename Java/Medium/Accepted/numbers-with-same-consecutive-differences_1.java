class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        if (n == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(res, n - 1, k, i);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(List<Integer> res, int n, int k, int num) {
        if (n == 0) {
            res.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit - k >= 0) dfs(res, n - 1, k, num * 10 + lastDigit - k);
        if (k != 0 && lastDigit + k <= 9) dfs(res, n - 1, k, num * 10 + lastDigit + k);
    }
}