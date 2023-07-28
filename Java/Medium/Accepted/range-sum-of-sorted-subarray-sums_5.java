class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        int[] sums = new int[n * (n + 1) / 2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[k++] = sum;
            }
        }
        Arrays.sort(sums);
        int result = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            result = (result + sums[i]) % (1000000007);
        }
        return result;
    }
}