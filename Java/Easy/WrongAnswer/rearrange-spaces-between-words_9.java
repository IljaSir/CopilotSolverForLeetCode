class Solution {
    public String reorderSpaces(String text) {
        
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.length() > 0) {
                count++;
            }
        }
        int n = words.length;
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        if (count == 1) {
            return words[0] + " ".repeat(spaces);
        }
        int space = spaces / (count - 1);
        int extra = spaces % (count - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (words[i].length() > 0) {
                sb.append(words[i]);
                if (i < n - 1) {
                    sb.append(" ".repeat(space));
                }
            }
        }
        sb.append(" ".repeat(extra));
        return sb.toString();
    }
}