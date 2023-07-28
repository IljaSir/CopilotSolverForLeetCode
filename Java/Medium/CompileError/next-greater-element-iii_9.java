class Solution {
    public int nextGreaterElement(int n) {
        
        int[] digits = new int[10;
        int i 0;
        while (n > 0) {
           digits[i++] = n % 10;
            n = n / 10;
        }
        int k = 0;
        for (k = 0; k < i - 1; k++) {
            if (digits[k] > digits[k + 1]) {
                break;
            }
        }
        if (k == i - 1) {
            return -1;
        }
        int x = digits[k + 1];
        int j = k + 1;
        for (int l = k + 1; l < i; l++) {
            if (digits[l] > digits[k + 1] && digits[l] < x) {
                j = l;
            }
        }
        int temp = digits[k + 1];
        digits[k + 1] = digits[j];
        digits[j] = temp;
        long result = 0;
        for (int l = 0; l < i; l++) {
            result = result * 10 + digits[i - l - 1];
        }
        if (result > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)resul

        char[] c = String.valueOf(n).toCharArray();
        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) i--;
        if (i < 0) return -1;
        int j = c.length - 1;
        while (c[j] <= c[i]) j--;
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        Arrays.sort(c, i + 1, c.length);
        long res = Long.parseLong(new String(c));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
}