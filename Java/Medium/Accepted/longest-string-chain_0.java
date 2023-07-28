class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i)
                best = Math.max(best, dp.getOrDefault(word.substring(0, i) + word.substring(i + 1), 0) + 1);
            dp.put(word, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}