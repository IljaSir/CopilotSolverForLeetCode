class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (isConcatenated(word, set)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isConcatenated(String word, Set<String> set) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= n; j++) {
                    if (set.contains(word.substring(i, j))) {
                        dp[j] = true;
                        if (j == n) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}