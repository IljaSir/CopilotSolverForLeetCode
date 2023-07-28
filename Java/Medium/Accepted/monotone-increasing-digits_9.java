class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int nlen = chars.length;
        int i = 0;
        while (i < nlen - 1 && chars[i] <= chars[i + 1]) {
            i++;
        }
        if (i == nlen - 1) {
            return n;
        }
        while (i > 0 && chars[i] == chars[i - 1]) {
            i--;
        }
        chars[i]--;
        for (int j = i + 1; j < nlen; j++) {
            chars[j] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}