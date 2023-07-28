class Solution {
    public boolean canConvertString(String s, String t, int k) {
        
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > 0) {
                counts[diff]++;
            }
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > (k - i) / 26 + 1) {
                return false;
            }
        }
        return true;
    }
}