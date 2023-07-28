class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        int i = s.indexOf("(");
        int j = t.indexOf("(");
        if (i == -1 && j == -1) return s.equals(t);
        if (i == -1) return s.equals(t.substring(0, j) + t.substring(j + 1, t.length() - 1) + t.substring(j + 1, t.length() - 1));
        if (j == -1) return t.equals(s.substring(0, i) + s.substring(i + 1, s.length() - 1) + s.substring(i + 1, s.length() - 1));
        String s1 = s.substring(0, i);
        String s2 = s.substring(i + 1, s.length() - 1);
        String t1 = t.substring(0, j);
        String t2 = t.substring(j + 1, t.length() - 1);
        return s1.equals(t1) && s2.equals(t2);
    }
}