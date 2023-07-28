class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int[] allowedArr = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            allowedArr[allowed.charAt(i) - 'a'] = 1;
        }
        int count = 0;
        for (String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                if (allowedArr[word.charAt(i) - 'a'] == 0) {
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