class Solution {
    public int compress(char[] chars) {
        
        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            int k = j;
            while (k < n && chars[k] == chars[j]) {
                k++;
            }
            chars[i++] = chars[j];
            if (k - j > 1) {
                String count = String.valueOf(k - j);
                for (int m = 0; m < count.length(); m++) {
                    chars[i++] = count.charAt(m);
                }
            }
            j = k;
        }
        return i;
    }
}