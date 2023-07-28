class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            } else {
                words++;
            }
        }
        int spacesBetweenWords = words == 1 ? 0 : spaces / (words - 1);
        int extraSpaces = words == 1 ? spaces : spaces % (words - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i));
            } else {
                if (words > 1) {
                    for (int j = 0; j < spacesBetweenWords; j++) {
                        sb.append(' ');
                    }
                }
                words--;
            }
        }
        for (int j = 0; j < extraSpaces; j++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}