class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        int i = s.indexOf("(");
        int j = t.indexOf("(");
        String s1 = s.substring(0, i);
        String s2 = s.substring(i+1, s.length()-1);
        String t1 = t.substring(0, j);
        String t2 = t.substring(j+1, t.length()-1);
        String s3 = s1 + s2;
        String t3 = t1 + t2;
        String s4 = s1 + s2 + s2 + s2 + s2 + s2 + s2 + s2 + s2 + s2;
        String t4 = t1 + t2 + t2 + t2 + t2 + t2 + t2 + t2 + t2 + t2;
        if (s1.equals(t1) && s2.equals(t2)) {
            return true;
        } else if (s3.equals(t3)) {
            return true;
        } else if (s4.equals(t4)) {
            return true;
        } else {
            return false;
        }
    }
}