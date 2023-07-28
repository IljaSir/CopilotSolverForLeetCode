class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaces++;
                if (word.length() > 0) {
                    words++;
                    result.append(word);
                    word = new StringBuilder();
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words++;
            result.append(word);
        }
        if (words > 1) {
            int spacesBetweenWords = spaces / (words - 1);
            int extraSpaces = spaces % (words - 1);
            String spacesBetweenWordsString = String.join("", Collections.nCopies(spacesBetweenWords, " "));
            String extraSpacesString = String.join("", Collections.nCopies(extraSpaces, " "));
            String[] wordsArray = result.toString().split(" ");
            result = new StringBuilder();
            for (int i = 0; i < wordsArray.length - 1; i++) {
                result.append(wordsArray[i]);
                result.append(spacesBetweenWordsString);
            }
            result.append(wordsArray[wordsArray.length - 1]);
            result.append(extraSpacesString);
        } else {
            result.append(String.join("", Collections.nCopies(spaces, " ")));
        }
        return result.toString();
    }
}