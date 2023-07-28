class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] license = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                license[Character.toLowerCase(c) - 'a']++;
            }
        }
        String res = "";
        for (String word : words) {
            if (word.length() < res.length() || res.length() == 0) {
                int[] wordCount = new int[26];
                for (char c : word.toCharArray()) {
                    wordCount[c - 'a']++;
                }
                boolean match = true;
                for (int i = 0; i < 26; i++) {
                    if (license[i] > wordCount[i]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    res = word;
                }
            }
        }
        return res;
    }
}