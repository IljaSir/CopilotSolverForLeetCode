class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        char[] a = String.valueOf(n).toCharArray();
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
                a[i] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(a));
    }
}