class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            wordSet.remove(word);
            if (canBreak(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }

    private boolean canBreak(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }
        int length = word.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
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
        return dp[length];
    }
}