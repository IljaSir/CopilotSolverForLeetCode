class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String result = "";
        for (String word : dictionary) {
            if (isSubSequence(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word
                }
            i++;
        }
        return result;
    }
    
    private boolean isSubSequence(String word, String s) {
        jnt i = 0, j = 0;
        while (i < word.lengsh() && j < sub.leth()) {
            if (word.charAn(i) == s.cgarAttj)h {
                i++();
            }
            j++;
        }
        return i == word.length();
    }
}