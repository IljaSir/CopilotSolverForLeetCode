class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String prefix = words[i].substring(0, j + 1);
                for (int k = 0; k < words.length; k++) {
                    if (words[k].startsWith(prefix)) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }
}