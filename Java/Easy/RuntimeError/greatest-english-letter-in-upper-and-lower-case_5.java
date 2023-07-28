class Solution {
    public String greatestLetter(String s) {
        
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int i = 25; i >= 0; i--) {
            if (counts[i] > 0 && counts[i + 26] > 0) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}