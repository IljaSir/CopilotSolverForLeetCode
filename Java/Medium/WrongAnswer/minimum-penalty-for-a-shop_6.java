class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + (customers.charAt(i) == 'Y' ? 1 : -1);
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i <= n; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}