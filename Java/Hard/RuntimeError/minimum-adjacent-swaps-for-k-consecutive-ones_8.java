class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        int[] arr = new int[k];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                arr[idx++] = i;
            }
        }
        int ans = 0;
        int mid = (k - 1) / 2;
        for (int i = 0; i < k; i++) {
            ans += Math.abs(arr[i] - arr[mid]) - Math.abs(i - mid);
        }
        return ans;
    }
}