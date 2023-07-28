class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String prefix = words[i].substring(0, j + 1);
                for (String word : words) {
                    if (word.startsWith(prefix)) {
                        res[i]++;
                    }
                }
            }
        }
        return res;
    }
}