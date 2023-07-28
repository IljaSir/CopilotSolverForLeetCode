class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        String[] s1 = s.split("\\(");
        String[] s2 = t.split("\\(");
        String s1Int = s1[0].split("\\.")[0];
        String s1Dec = s1[0].split("\\.")[1];
        String s2Int = s2[0].split("\\.")[0];
        String s2Dec = s2[0].split("\\.")[1];
        String s1Rep = s1.length > 1 ? s1[1].substring(0, s1[1].length() - 1) : "";
        String s2Rep = s2.length > 1 ? s2[1].substring(0, s2[1].length() - 1) : "";
        int len1 = s1Rep.length();
        int len2 = s2Rep.length();
        int len = Math.max(len1, len2);
        if (len1 < len) s1Rep = s1Rep + s1Rep.substring(0, len - len1);
        if (len2 < len) s2Rep = s2Rep + s2Rep.substring(0, len - len2);
        System.out.println(s1Int + " " + s1Dec + " " + s1Rep);
        System.out.println(s2Int + " " + s2Dec + " " + s2Rep);
        return s1Int.equals(s2Int) && s1Dec.equals(s2Dec) && s1Rep.equals(s2Rep);
    }
}