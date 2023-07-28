class Solution {
    public long minimumRemoval(int[] beans) {
        
        int n = beans.length;
        long sum = 0;
        for (int b : beans) {
            sum += b;
        }
        long avg = sum / n;
        long mod = sum % n;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (i < mod) {
                res += Math.abs(beans[i] - avg - 1);
            } else {
                res += Math.abs(beans[i] - avg);
            }
        }
        return res / 2;
    }
}