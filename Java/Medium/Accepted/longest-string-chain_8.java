class Solution {
    public int longestStrChain(String[] words) {
        
        int max = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                dp.put(word, Math.max(dp.getOrDefault(prev, 0) + 1, dp.get(word)));
            }
            max = Math.max(max, dp.get(word));
        }
        return max;
    }
}