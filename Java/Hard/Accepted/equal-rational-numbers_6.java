class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        return solve(s) == solve(t);
    }
    private double solve(String s) {
        int i = s.indexOf("(");
        if (i == -1) {
            return Double.parseDouble(s);
        }
        String base = s.substring(0, i);
        String rep = s.substring(i + 1, s.length() - 1);
        for (int j = 0; j < 20; ++j) {
            base += rep;
        }
        return Double.parseDouble(base);
    }
}