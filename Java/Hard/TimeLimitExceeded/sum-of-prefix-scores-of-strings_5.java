class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int score = 0;
            for (int j = 1; j <= words[i].length(); j++) {
                for (int k = 0; k < words.length; k++) {
                    if (words[k].startsWith(words[i].substring(0, j))) {
                        score++;
                    }
                }
            }
            ans[i] = score;
        }
        return ans;
    }
}