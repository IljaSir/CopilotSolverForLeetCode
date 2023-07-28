class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        int[] arr = new int[n * (n + 1) / 2];
        int i = 0;
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int k = j; k < n; k++) {
                sum += nums[k];
                arr[i++] = sum;
            }
        }
        Arrays.sort(arr);
        int sum = 0;
        for (i = left - 1; i < right; i++) {
            sum += arr[i];
        }
        return sum;
    }
}