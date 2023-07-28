class Solution {
    public long minimumRemoval(int[] beans) {
        
        long total = 0;
        int max = 0;
        for (int b : beans) {
            total += b;
            max = Math.max(max, b);
        }
        long[] count = new long[max + 1];
        for (int b : beans) {
            count[b]++;
        }
        long[] sum = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            sum[i] = sum[i - 1] + count[i];
        }
        long result = total;
        for (int i = 1; i <= max; i++) {
            long c = total;
            for (int j = i; j <= max; j += i) {
                c -= sum[Math.min(max, j + i - 1)] - sum[j - 1];
            }
            result = Math.min(result, c);
        }
        return result;
    }
}