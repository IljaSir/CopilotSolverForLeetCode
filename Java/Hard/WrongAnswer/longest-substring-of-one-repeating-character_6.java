class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] lengths = new int[queryCharacters.length()];
        int[] counts = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            max = Math.max(max, counts[s.charAt(i) - 'a']);
            for (int j = 0; j < queryCharacters.length(); j++) {
                if (i == queryIndices[j]) {
                    counts[s.charAt(i) - 'a']--;
                    max = Math.max(max, counts[s.charAt(i) - 'a']);
                    lengths[j] = max;
                }
            }
        }
        return lengths;
    }
}