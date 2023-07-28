class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                diff++;
            }
        }
        if (diff != 2) return false;
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        return Arrays.equals(s1Chars, s2Chars);
    }
}