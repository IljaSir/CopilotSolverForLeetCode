class Solution {
    public boolean queryString(String s, int n) {
        
        int[] a = new int[32];
        int[] b = new int[32];
        int i = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                a[i] = 1;
            }
            n /= 2;
            i++;
        }
        int j = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                b[j] = 1;
            }
            j++;
        }
        for (i = 0; i < 32; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}