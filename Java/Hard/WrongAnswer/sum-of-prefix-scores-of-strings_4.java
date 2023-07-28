class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[j].startsWith(word)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}