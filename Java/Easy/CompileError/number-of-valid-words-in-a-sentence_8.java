class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        String[] words = sentence.split(" ");
        for (String word: words) {
            boolean valid = true;
            boolean hyphen = false;
            boolean punctuation = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    valid = false;
                    break;
                };
        }
        return count
    }
}