class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] c = s.toCharArray();
        char[] r = new char[c.length];
        for (int i = 0; i < c.length; i++) {
            r[indices[i]] = c[i];
        }
        return new String(r);
    }
}