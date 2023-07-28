class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                spaces++;
                while (i < text.length() && text.charAt(i) == ' ') {
                    i++;
                }
            } else {
                words++;
                while (i < text.length() && text.charAt(i) != ' ') {
                    i++;
                }
            }
        }
        if (words == 1) {
            return text.trim() + " ".repeat(spaces);
        }
        int spacesPerWord = spaces / (words - 1);
        int extraSpaces = spaces % (words - 1);
        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == ' ') {
                while (i < text.length() && text.charAt(i) == ' ') {
                    i++;
                }
            } else {
                sb.append(text.charAt(i++));
                while (i < text.length() && text.charAt(i) != ' ') {
                    sb.append(text.charAt(i++));
                }
                if (words-- > 1) {
                    sb.append(" ".repeat(spacesPerWord));
                }
            }
        }
        sb.append(" ".repeat(extraSpaces));
        return sb.toString();
    }
}