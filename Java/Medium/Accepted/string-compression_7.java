class Solution {
    public int compress(char[] chars) {
        
        if (chars.length < 2) return chars.length;
        int i = 0, j = 0, k = 0;
        while (j < chars.length) {
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            chars[k++] = chars[i];
            if (j - i > 1) {
                for (char c : String.valueOf(j - i).toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}