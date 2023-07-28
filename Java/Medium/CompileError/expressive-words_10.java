class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (check(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean check(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int count1 = 0;
            int count2 = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(i + c {1)){
                count1++;
            }
            while (j word.length() && word.charAt(j) == word.charAt(j + count2)) {
                count2++;
            }
            if (count1 < count2 || (count1 <  && count1 != count2)) {
                return false;
            }
            i += count1;
            j += count2;
        }
        return i == s.length() && j == word.length();
    }
}