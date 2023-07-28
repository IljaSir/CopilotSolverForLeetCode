class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        int[] sums = new int[n * (n + 1) / 2];
        int i = 0;
        for (int len = 1; len <= n; len++) {
            for (int j = 0; j <= n - len; j++) {
                sums[i++] = Arrays.stream(nums, j, j + len).sum();
            }
        }
        Arrays.sort(sums);
        int sum = 0;
        for (i = left - 1; i < right; i++) {
            sum += sums[i];
        }
        return sum % 1000000007;
    }
}