class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int len = arr.length;
        int i = 0;
        while (i + 1 < len && arr[i] <= arr[i + 1]) {
            i++;
        }
        if (i == len - 1) {
            return 0;
        }
        int j = len - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        int ans = Math.min(len - i - 1, j);
        int k = 0;
        while (k <= i && j < len) {
            if (arr[k] <= arr[j]) {
                ans = Math.min(ans, j - k - 1);
                k++;
            } else {
                j++;
            }
        }
        return ans;
    }
}