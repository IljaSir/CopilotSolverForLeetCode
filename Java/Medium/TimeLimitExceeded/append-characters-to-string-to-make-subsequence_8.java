class Solution {
    public int appendCharacters(String s, String t) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s.length() || j < t.length()) {
            if (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                count++;
            }
        }
        return count;
    }
}