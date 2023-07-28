class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] left = new int[n+2];
        int[] right = new int[n+2];
        int[] len = new int[n+2];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            left[a] = a - 1;
            right[a] = a + 1;
            len[a] = 1;
            len[left[a]] += len[a];
            len[right[a]] += len[a];
            left[right[a]] = left[a];
            right[left[a]] = right[a];
            if (len[left[a]] == m || len[right[a]] == m) {
                res = i;
            }
        }
        return res;
    }
}