class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char c: letters) {
            letterMap.put(c, letterMap.getOrDefault(c, 0) + 1);
        }
        return dfs(words, 0, letterMap, score);
    }
    
    private int dfs(String[] words, int index, Map<Character, Integer> letterMap, int[] score) {
        if (index == words.length) {
            return 0;
        }
        int ans = dfs(words, index + 1, letterMap, score);
        String word = words[index];
        Map<Character, Integer> wordMap = new HashMap<>();
        int wordScore = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
            wordScore += score[c - 'a'];
        }
        boolean valid = true;
        for (Map.Entry<Character, Integer> entry: wordMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (letterMap.getOrDefault(c, 0) < count) {
                valid = false;
                break;
            }
        }
        if (valid) {
            for (Map.Entry<Character, Integer> entry: wordMap.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                letterMap.put(c, letterMap.get(c) - count);
            }
            ans = Math.max(ans, wordScore + dfs(words, index + 1, letterMap, score));
            for (Map.Entry<Character, Integer> entry: wordMap.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                letterMap.put(c, letterMap.get(c) + count);
            }
        }
        return ans;
    }
}