class Solution {
    public int countPrefixes(String[] words, String s) {
        
        int count = 0;
        for (String word: words) {
            int i = 0;
            for (char c: word.toCharArray()) {
                if (i >= s.length() || c != s.charAt(i)) {
                    break;
                }
                i++;
            }
            if (i == s.length()) {
                count++;
            }
        }
        return count;
    }
}