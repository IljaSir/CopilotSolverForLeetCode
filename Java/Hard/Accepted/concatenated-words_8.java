class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (canForm(word, set)) {
                result.add(word);
            }
            set.add(word);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> set) {
        if (set.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 0; i < word.length(); i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + 1; j <= word.length(); j++) {
                if (set.contains(word.substring(i, j))) {
                    dp[j] = true;
                }
            }
            if (dp[word.length()]) {
                return true;
            }
        }
        return false;
    }
}