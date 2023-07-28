class Solution {
    public boolean winnerOfGame(String colors) {
        
        int n = colors.length();
        int[] a = new int[n];
        int[] b = new int[n];
        if (colors.charAt(0) == 'A') {
            a[0] = 1;
        } else {
            b[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == 'A') {
                a[i] = a[i - 1] + 1;
                b[i] = b[i - 1];
            } else {
                b[i] = b[i - 1] + 1;
                a[i] = a[i - 1];
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (a[i] > a[i - 1] && a[i - 1] > a[i - 2]) {
                cnt++;
            }
            if (b[i] > b[i - 1] && b[i - 1] > b[i - 2]) {
                cnt++;
            }
        }
        return cnt > n / 2;
    }
}