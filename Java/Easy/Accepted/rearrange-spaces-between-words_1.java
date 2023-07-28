class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        String[] wordArray = text.trim().split("\\s+");
        words = wordArray.length;
        if (words == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(wordArray[0]);
            for (int i = 0; i < spaces; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int spacesBetween = spaces / (words - 1);
        int extraSpaces = spaces % (words - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordArray.length; i++) {
            sb.append(wordArray[i]);
            if (i < wordArray.length - 1) {
                for (int j = 0; j < spacesBetween; j++) {
                    sb.append(' ');
                }
            }
        }
        for (int i = 0; i < extraSpaces; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}