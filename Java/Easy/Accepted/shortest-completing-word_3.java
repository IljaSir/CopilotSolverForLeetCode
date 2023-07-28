class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] count = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = null;
        for (String word : words) {
            if (isSubstr(word, count) && (result == null || result.length() > word.length())) {
                result = word;
            }
        }
        return result;
    }
    
    private boolean isSubstr(String word, int[] count) {
        int[] count2 = new int[26];
        for (char c : word.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }
}