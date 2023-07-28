class Solution {
    public String modifyString(String s) {
        
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '?') {
                c[i] = 'a';
                while ((i > 0 && c[i] == c[i - 1]) || (i < c.length - 1 && c[i] == c[i + 1])) {
                    c[i]++;
                }
            }
        }
        return new String(c);
    }
}