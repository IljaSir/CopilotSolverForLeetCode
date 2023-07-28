class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        int[] letters = new int[26];
        int[] digits = new int[10];
        int[] wordDigits = new int[words.length];
        int resultDigits = 0;
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        maxLen = Math.max(maxLen, result.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'A';
                letters[index] = 1;
                wordDigits[i] += (int) Math.pow(10, word.length() - j - 1);
            }
        }
        for (int j = 0; j < result.length(); j++) {
            int index = result.charAt(j) - 'A';
            letters[index] = 1;
            resultDigits += (int) Math.pow(10, result.length() - j - 1);
        }
        int[] letterDigits = new int[26];
        int[] letterCount = new int[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'A';
                letterDigits[index] += wordDigits[i];
                letterCount[index]++;
            }
        }
        for (int j = 0; j < result.length(); j++) {
            int index = result.charAt(j) - 'A';
            letterDigits[index] -= resultDigits;
            letterCount[index]++;
        }
        int[] letterMap = new int[26];
        for (int i = 0; i < 26; i++) {
            letterMap[i] = -1;
        }
        int[] digitMap = new int[10];
        for (int i = 0; i < 10; i++) {
            digitMap[i] = -1;
        }
        return dfs(letters, letterDigits, letterCount, letterMap, digitMap, 0, 0, maxLen);
    }
}