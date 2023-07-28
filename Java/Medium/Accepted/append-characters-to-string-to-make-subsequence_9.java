class Solution {
    public int appendCharacters(String s, String t) {
        
        int i = 0;
        int j = 0;
        int index = 0;
        int count = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                index = i;
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j < t.length()) {
            count = t.length() - j;
        }
        return count;
    }
}