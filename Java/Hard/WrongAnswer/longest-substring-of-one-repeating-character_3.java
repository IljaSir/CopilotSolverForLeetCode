class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] result = new int[queryIndices.length];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);
            count[s.charAt(index) - 'a']--;
            count[c - 'a']++;
            s = s.substring(0, index) + c + s.substring(index + 1);
            result[i] = findMax(count);
        }
        return result;
    }
    
    private int findMax(int[] count) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
}