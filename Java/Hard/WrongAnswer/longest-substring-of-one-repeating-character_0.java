class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] result = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            result[i] = longestRepeating(s, queryCharacters.charAt(i), queryIndices[i]);
        }
        return result;
    }

    private int longestRepeating(String s, char queryCharacter, int queryIndex) {
        int result = 0;
        int left = queryIndex;
        int right = queryIndex;
        while (left >= 0 && s.charAt(left) == queryCharacter) {
            left--;
        }
        while (right < s.length() && s.charAt(right) == queryCharacter) {
            right++;
        }
        result = right - left - 1;
        return result;
    }
}