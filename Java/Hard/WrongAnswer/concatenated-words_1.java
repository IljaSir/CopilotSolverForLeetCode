class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (canForm(word, wordSet)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }
                if (wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}