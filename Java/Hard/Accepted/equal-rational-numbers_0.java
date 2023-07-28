class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        return toDouble(s) == toDouble(t);
    }
    private double toDouble(String s) {
        int i = s.indexOf('(');
        if (i > 0) {
            String base = s.substring(0, i);
            String rep = s.substring(i + 1, s.length() - 1);
            for (int j = 0; j < 20; ++j)
                base += rep;
            s = base;
        }
        return Double.valueOf(s);
    }
}