class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int n = arr.length;
        for (int i = 0; i < n - m; i++) {
            int j = i;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            if ((j - i) / m >= k) {
                return true;
            }
        }
        return false;
    }
}