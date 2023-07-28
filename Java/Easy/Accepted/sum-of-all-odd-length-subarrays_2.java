class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += 2) {
                ans += prefix[j] - prefix[i - 1];
            }
        }
        return ans;
    }
}