class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        if (n == 1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(ans, i, n, k);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
    private void dfs(List<Integer> ans, int num, int n, int k) {
        if (n == 0) {
            ans.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit - k >= 0) {
            dfs(ans, num * 10 + lastDigit - k, n - 1, k);
        }
        if (lastDigit + k <= 9 && k != 0) {
            dfs(ans, num * 10 + lastDigit + k, n - 1, k);
        }
    }
}