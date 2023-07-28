class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String longest = "";
        for(String word : dictionary) {
            //System.out.println(word);
            if(word.length() < longest.length()) continue;
            if(word.length() == longest.length() && word.compareTo(longest) > 0) continue;
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
        return i == a.length();
    }
}