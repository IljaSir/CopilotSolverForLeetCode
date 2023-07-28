class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        int i = 1;
        while (i < c.length && c[i - 1] <= c[i]) {
            i++;
        }
        if (i < c.length) {
            while (i > 0 && c[i - 1] > c[i]) {
                c[i - 1]--;
                i--;
            }
            for (int j = i + 1; j < c.length; j++) {
                c[j] = '9';
            }
        }
        return Integer.parseInt(String.valueOf(c));
    }
}