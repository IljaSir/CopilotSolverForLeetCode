class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] letters = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                letters[Character.toLowerCase(c) - 'a']++;
            }
        }
        String ans = "";
        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            boolean match = true;
            for (int i = 0; i < 26; i++) {
                if (letters[i] > count[i]) {
                    match = false;
                    break;
                }
            }
            if (match && (ans.equals("") || ans.length() > word.length())) {
                ans = word;
            }
        }
        return ans;
    }
}