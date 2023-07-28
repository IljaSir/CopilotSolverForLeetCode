class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int target = n / 4;
        for (int i = 0; i < n; i++) {
            int j = i + target;
            if (j >= n) {
                j = n - 1;
            }
            if (arr[j] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }
}