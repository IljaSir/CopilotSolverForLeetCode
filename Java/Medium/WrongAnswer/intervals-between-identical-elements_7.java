class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] res = new long[n];
        int[] prev = new int[100001];
        for (int i = 1; i <= 100000; i++) {
            prev[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (prev[arr[i]] != -1) {
                res[i] += i - prev[arr[i]];
                res[prev[arr[i]]] += i - prev[arr[i]];
            }
            prev[arr[i]] = i;
        }
        return res;
    }
}