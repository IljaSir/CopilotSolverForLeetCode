class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) {
            return result;
        }
        helper(s, wordSet, maxLen, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper(String s, Set<String> wordSet, int maxLen, int index, List<String> list, List<String> result) {
        if (index == s.length()) {
            result.add(String.join(" ", list));
            return;
        }
        for (int i = index + 1; i <= s.length() && i - index <= maxLen; i++) {
            String sub = s.substring(index, i);
            if (wordSet.contains(sub)) {
                list.add(sub);
                helper(s, wordSet, maxLen, i, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}