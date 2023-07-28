class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int count = 0;
        for (String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                if (allowed.indexOf(word.charAt(i)) == -1) {
                    break;
                }
            }
            if (i == word.length()) {
                count++;
            }
        }
        return count;
    }
}