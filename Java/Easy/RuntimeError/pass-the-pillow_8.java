class Solution {
    public int passThePillow(int n, int time) {
        
        int[] a = new int[n];
        int i = 0, j = n - 1, c = 0;
        while (c < time) {
            a[i] = 1;
            a[j] = 1;
            c++;
            i++;
            j--;
            if (i == j) {
                i = 0;
                j = n - 1;
            }
        }
        for (int k = 0; k < n; k++) {
            if (a[k] == 1) {
                return k + 1;
            }
        }
        return 0;
    }
}