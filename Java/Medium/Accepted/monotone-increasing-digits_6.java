class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        String s = String.valueOf(n);
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
        }
        int i = 1;
        while (i < a.length && a[i - 1] <= a[i]) {
            i++;
        }
        if (i < a.length) {
            while (i > 0 && a[i - 1] > a[i]) {
                a[i - 1]--;
                i--;
            }
            for (i++; i < a.length; i++) {
                a[i] = 9;
            }
        }
        int res = 0;
        for (i = 0; i < a.length; i++) {
            res = res * 10 + a[i];
        }
        return res;
    }
}