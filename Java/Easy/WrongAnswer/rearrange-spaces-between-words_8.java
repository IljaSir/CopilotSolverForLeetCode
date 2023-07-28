class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        String[] wordArray = text.split(" ");
        for (String word : wordArray) {
            if (word.length() > 0) {
                words++;
            }
        }
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaces++;
            }
        }
        int numSpaces = 0;
        if (words > 1) {
            numSpaces = spaces / (words - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : wordArray) {
            if (word.length() > 0) {
                sb.append(word);
                for (int i = 0; i < numSpaces; i++) {
                    sb.append(' ');
                }
            }
        }
        for (int i = 0; i < (spaces - (words - 1) * numSpaces); i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}