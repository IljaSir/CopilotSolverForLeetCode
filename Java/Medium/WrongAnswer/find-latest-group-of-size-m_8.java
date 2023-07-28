class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] groups = new int[n + 2];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            int left = groups[index - 1];
            int right = groups[index + 1];
            if (left == m || right == m) {
                res = i;
            }
            groups[index] = groups[index - left] = groups[index + right] = left + right + 1;
        }
        return res;
    }
}