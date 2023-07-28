class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> dict = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (wordBreak(word, dict)) {
                ans.add(word);
            }
            dict.add(word);
        }
        return ans;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}