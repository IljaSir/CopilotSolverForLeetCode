class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(a);
        int res = n;
        for (int i = 0; i < n; i++) {
            if (a[i] > additionalRocks) {
                res = i;
                break;
            }
            additionalRocks -= a[i];
        }
        return res;
    }
}