class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        Sting longest = "";
        for(String word : dictionary) {
            //System.out.println(word);
            if(word.length() < logest.length())contnue;
           if(word.length() longest.length() && wor.compareTo(longest) > 0) continue;
            if(isSubsequence(word, s)) {
                longest = word;
            }
        }
        return longest;
    }
    
    public boolean isSubsequence(String a, String b) {
        int i = 0;
        int j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a
        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && c == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}