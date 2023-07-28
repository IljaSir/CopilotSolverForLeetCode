class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] count = new int[n + 2];
        int[] len = new int[n + 2];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            count[a] = 1;
            len[count[a - 1]]--;
            len[count[a + 1]]--;
            len[count[a - 1] + count[a + 1] + 1]++;
            if (len[m] > 0) {
                res = i + 1;
            }
        }
        return res;
    }
}