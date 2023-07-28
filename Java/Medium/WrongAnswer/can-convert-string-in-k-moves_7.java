class Solution {
    public boolean canConvertString(String s, String t, int k) {
        
        if (s.length() != t.length()) return false;
        int[] shifts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int shift = t.charAt(i) - s.charAt(i);
            if (shift < 0) shift += 26;
            shifts[shift]++;
        }
        for (int i = 1; i < 26; i++) {
            if (shifts[i] > (k - i) / 26 + 1) return false;
        }
        return true;
    }
}