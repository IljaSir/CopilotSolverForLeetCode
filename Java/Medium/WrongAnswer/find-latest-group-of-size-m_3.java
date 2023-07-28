class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] count = new int[n + 2];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            count[a] = count[a - 1] + count[a + 1] + 1;
            if (count[a - count[a - 1]] == m || count[a + count[a + 1]] == m) {
                res = i;
            }
        }
        return res;
    }
}