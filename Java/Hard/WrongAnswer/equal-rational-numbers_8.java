class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        return getDecimal(s).equals(getDecimal(t));
    }
    
    private String getDecimal(String s) {
        int i = s.indexOf('(');
        if (i < 0) {
            return s;
        }
        String s1 = s.substring(0, i);
        String s2 = s.substring(i + 1, s.length() - 1);
        for (int j = 0; j < 20; j++) {
            s1 += s2;
        }
        return s1;
    }
}