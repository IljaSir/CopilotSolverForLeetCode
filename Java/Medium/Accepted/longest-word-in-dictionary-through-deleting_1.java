class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String longestWord = "";
        for (String word: dictionary) {
            int l1 = longestWord.length(), l2 = word.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(word) < 0)) {
                continue;
            }
            if (isSubstr(s, word)) {
                longestWord = word;
            }
        }
        return longestWord;
    }
    
    public boolean isSubstr(String str, String sub) {
        int i = 0, j = 0;
        while (i < str.length() && j < sub.length()) {
            if (str.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}