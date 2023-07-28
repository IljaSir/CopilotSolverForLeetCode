class Solution {
    public int minOperations(int n) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (2 * i) + 1;
        }
        int mid = arr[n / 2];
        int ans = 0;
        for (int num : arr) {
            ans += Math.abs(mid - num) / 2;
        }
        return ans;
    }
}