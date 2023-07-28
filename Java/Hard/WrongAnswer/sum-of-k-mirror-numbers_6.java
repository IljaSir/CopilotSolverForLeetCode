class Solution {
    public long kMirror(int k, int n) {
        
        long res = 0;
        int[] arr = new int[32];
        int len = 0;
        int i = 0;
        while (n > 0) {
            arr[i++] = n % k;
            n /= k;
            len++;
        }
        for (int j = 0; j < n; j++) {
            res += getMirrorNum(arr, len, k);
        }
        return res;
    }
    
    private long getMirrorNum(int[] arr, int len, int k) {
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr[i];
        }
        for (int i = 0; i < len; i++) {
            res[len + i] = arr[len - i - 1];
        }
        long sum = 0;
        for (int i = 0; i < 2 * len; i++) {
            sum = sum * k + res[i];
        }
        return sum;
    }
}