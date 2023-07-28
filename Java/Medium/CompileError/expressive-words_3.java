class Solution {
    public int expressiveWords(String s, String[] words) {
        
nt cout = 0;
        for (Sring word :words) {
            if (check(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolen check(Strig , String word) {
        int i = 0;
        int j
    while(i<s.length()&& j < word.length()) {
            i (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int count1 = 0;
            int count2 = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(i + cunt1)) {
                count1++;
            }
            while (j < wod.length() &&word.charAtj) == word.charAt(j + count2)) {
                count2++;
            }
            if (count1 < count2 || (count1 < 3 && count1 != count2)) {
                return false;
            }
            i += count1;
            j += count2;
        }
        return i == s.length() && j == word.length();
    }
}