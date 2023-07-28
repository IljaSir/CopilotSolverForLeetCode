class Solution {
    public int numOfSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            count[sum[i] % 2]++;
        }
        return (int) ((count[0] * (count[0] + 1L) / 2 + count[1] * (count[1] + 1L) / 2) % 1000000007);
    }
}