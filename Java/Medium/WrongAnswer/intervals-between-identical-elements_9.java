class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] res = new long[n];
        int[] count = new int[100001];
        int[] last = new int[100001];
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            count[v]++;
            res[i] = (long) i - last[v];
            last[v] = i;
        }
        Arrays.fill(last, n);
        for (int i = n - 1; i >= 0; i--) {
            int v = arr[i];
            count[v]--;
            res[i] += last[v] - i;
            if (count[v] > 0) {
                last[v] = i;
            }
        }
        return res;
    }
}