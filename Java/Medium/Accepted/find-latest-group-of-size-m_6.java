class Solution {
    public int findLatestStep(int[] arr, int m) {
        
        int n = arr.length;
        int[] length = new int[n + 2];
        int[] cnt = new int[n + 1];
        int res = -1;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int left = length[a - 1];
            int right = length[a + 1];
            cnt[left]--;
            cnt[right]--;
            int sum = left + right + 1;
            cnt[sum]++;
            length[a - left] = sum;
            length[a + right] = sum;
            if (cnt[m] > 0) {
                res = i + 1;
            }
        }
        return res;
    }
}