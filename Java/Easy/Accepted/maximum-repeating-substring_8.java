class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int maxLength = sequence.length() / word.length();
        int max = 0;
        for (int i = 1; i <= maxLength; i++) {
            String wordToSearch = "";
            for (int j = 0; j < i; j++) {
                wordToSearch += word;
            }
            if (sequence.contains(wordToSearch)) {
                max = i;
            }
        }
        return max;
    }
}