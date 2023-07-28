class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] ans = new int[words.length];
        int i = 0;
        for (String word : words) {
            ans[i] = 0;
            for (int j = 1; j <= word.length(); j++) {
                ans[i] += countPrefix(words, word.substring(0, j));
            }
            i++;
        }
        return ans;
    }
    private int countPrefix(String[] words, String prefix) {
        int count = 0;
        for (String word : words) {
            if (word.length() >= prefix.length() && word.substring(0, prefix.length()).equals(prefix)) {
                count++;
            }
        }
        return count;
    }
}