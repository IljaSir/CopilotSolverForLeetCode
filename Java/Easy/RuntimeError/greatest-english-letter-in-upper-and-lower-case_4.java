class Solution {
    public String greatestLetter(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 25; i >= 0; i--) {
            if (count[i] > 0 && count[i + 26] > 0) {
                return String.valueOf((char)('A' + i));
            }
        }
        return "";
    }
}