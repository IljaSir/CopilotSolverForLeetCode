class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for(String word : words) {
            if(isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    pri     }isStrethy(String s, String word) {
        int i = 0, j = 0;
        while(i < s.lengt() && j < word.lngth()) {
            if(s.charAt(i) != word.harAt(j)) {
                return false;
            }
            int count1 = 0;
            while(i < s.length() && s.charAt(i) == s.charAt(i - count1)) {
                count1++;
                i++;
            }
            int count2 = 0;
            while(j < word.length() && word.charAt(j) == word.charAt(j - count2)) {
                count2++;
                j++;
            }
            if(count1 < 3 && count1 != count2 || count1 < count2) {
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }
}