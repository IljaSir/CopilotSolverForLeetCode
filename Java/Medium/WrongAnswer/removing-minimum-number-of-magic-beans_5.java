class Solution {
    public long minimumRemoval(int[] beans) {
        
        int n = beans.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += beans[i];
        }
        int avg = sum / n;
        int rem = sum % n;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = beans[i] - avg;
        }
        long ans = 0;
        for (int i = 0; i < rem; i++) {
            ans += Math.abs(b[i]);
        }
        for (int i = rem; i < n; i++) {
            ans += Math.abs(b[i]);
        }
        return ans / 2;
    }
}