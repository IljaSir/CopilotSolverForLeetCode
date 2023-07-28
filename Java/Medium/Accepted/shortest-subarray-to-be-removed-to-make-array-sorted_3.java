class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < n - 1 && arr[i] <= arr[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return 0;
        }
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        int ans = Math.min(n - i - 1, j);
        int l = 0, r = j;
        while (l <= i && r < n) {
            if (arr[l] <= arr[r]) {
                ans = Math.min(ans, r - l - 1);
                l++;
            } else {
                r++;
            }
        }
        return ans;
    }
}