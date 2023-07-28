class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        return helper(s) == helper(t);
    }
    public double helper(String s) {
        if (s.indexOf('.') == -1 && s.indexOf('(') == -1) {
            return Integer.parseInt(s);
        }
        int i = s.indexOf('.');
        int j = s.indexOf('(');
        if (j == -1) {
            j = s.length();
        }
        int a = Integer.parseInt(s.substring(0, i));
        String b = s.substring(i + 1, j);
        String c = j == s.length() ? "" : s.substring(j + 1, s.length() - 1);
        return a + (b + c).length() == 0 ? 0 : (double) (Integer.parseInt(b + c)) / Math.pow(10, b.length()) / Math.pow(10, c.length()) + a;
    }
}