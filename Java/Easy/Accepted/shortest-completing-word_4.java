class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] map = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                map[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = "";
        for (String word : words) {
            int[] wordMap = new int[26];
            for (char c : word.toCharArray()) {
                wordMap[c - 'a']++;
            }
            boolean isComplete = true;
            for (int i = 0; i < 26; i++) {
                if (map[i] > wordMap[i]) {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete && (result.length() == 0 || word.length() < result.length())) {
                result = word;
            }
        }
        return result;
    }
}