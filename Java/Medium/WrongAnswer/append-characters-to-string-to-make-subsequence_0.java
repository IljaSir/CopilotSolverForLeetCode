class Solution {
    public int appendCharacters(String s, String t) {
        
        int i = s.length() - 1;
        int j = t.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                i--;
                count++;
            }
        }
        return count + j + 1;
    }
}