class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        double s1 = getDouble(s);
        double s2 = getDouble(t);
        return Math.abs(s1 - s2) < 1e-9;
    }
    private double getDouble(String s) {
        int idx = s.indexOf("(");
        if (idx == -1) {
            return Double.parseDouble(s);
        }
        String s1 = s.substring(0, idx);
        String s2 = s.substring(idx + 1, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        for (int i = 0; i < 15; i++) {
            sb.append(s2);
        }
        return Double.parseDouble(sb.toString());
    }
}