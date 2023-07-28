class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] scores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String prefix = word.substring(0, j + 1);
                for (int k = 0; k < words.length; k++) {
                    if (words[k].startsWith(prefix)) {
                        scores[i]++;
                    }
                }
            }
        }
        return scores;
    }
}