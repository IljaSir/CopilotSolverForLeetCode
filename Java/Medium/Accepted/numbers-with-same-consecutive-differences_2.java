class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        if (n == 1) {
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n - 1, k, list);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private void dfs(int num, int n, int k, List<Integer> list) {
        if (n == 0) {
            list.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit + k <= 9) {
            dfs(num * 10 + lastDigit + k, n - 1, k, list);
        }
        if (lastDigit - k >= 0 && k != 0) {
            dfs(num * 10 + lastDigit - k, n - 1, k, list);
        }
    }
}