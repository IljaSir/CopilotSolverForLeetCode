class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        
        int mod = 1000000007;
        if (k == 1) {
            return kadane(arr, mod);
        }
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        if (sum < 0) {
            return kadane(arr, mod);
        }
        int[] temp = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
            temp[i + arr.length] = arr[i];
        }
        return (int) ((kadane(temp, mod) + (sum * (k - 2)) % mod) % mod);
    }
    
    private int kadane(int[] arr, int mod) {
        long sum = 0;
        long max = 0;
        for (int num : arr) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return (int) (max % mod);
    }
}