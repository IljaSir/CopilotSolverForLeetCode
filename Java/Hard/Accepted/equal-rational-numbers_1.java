class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        return getNumber(s) == getNumber(t);
    }
    private double getNumber(String s) {
        int i = s.indexOf('(');
        int j = s.indexOf(')');
        if (i > 0) {
            String base = s.substring(0, i);
            String rep = s.substring(i + 1, j);
            for (int k = 0; k < 20; k++) {
                base += rep;
            }
            return Double.parseDouble(base);
        }
        return Double.parseDouble(s);
    }
}