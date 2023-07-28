class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] result = new int[words.length];
        int[] prefixCount = new int[1001];
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j <= words[i].length(); j++) {
                result[i] += prefixCount[j];
            }
            prefixCount[words[i].length()]++;
        }
        return result;
    }
}