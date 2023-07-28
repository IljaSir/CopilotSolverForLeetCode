class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        String[] wordsArr = text.trim().split(" ");
        words = wordsArr.length;
        if (words == 1) {
            return text.trim() + " ".repeat(spaces);
        }
        int spacesPerWord = spaces / (words - 1);
        int extraSpaces = spaces % (words - 1);
        String result = "";
        for (int i = 0; i < wordsArr.length - 1; i++) {
            result += wordsArr[i] + " ".repeat(spacesPerWord);
        }
        result += wordsArr[wordsArr.length - 1] + " ".repeat(extraSpaces);
        return result;
    }
}