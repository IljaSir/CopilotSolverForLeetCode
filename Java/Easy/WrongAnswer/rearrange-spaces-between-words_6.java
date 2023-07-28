class Solution {
    public String reorderSpaces(String text) {
        
        int spaceCount = 0;
        int wordCount = 0;
        int wordStart = -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
                if (wordStart != -1) {
                    wordCount++;
                    wordStart = -1;
                }
            } else {
                if (wordStart == -1) {
                    wordStart = i;
                }
            }
        }
        if (wordStart != -1) {
            wordCount++;
        }
        StringBuilder sb = new StringBuilder();
        if (wordCount == 1) {
            sb.append(text.trim());
            for (int i = 0; i < spaceCount; i++) {
                sb.append(' ');
            }
        } else {
            int spaceCountPerWord = spaceCount / (wordCount - 1);
            int extraSpaceCount = spaceCount % (wordCount - 1);
            int wordStartIndex = -1;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    if (wordStartIndex != -1) {
                        sb.append(text.substring(wordStartIndex, i));
                        wordStartIndex = -1;
                        for (int j = 0; j < spaceCountPerWord; j++) {
                            sb.append(' ');
                        }
                    }
                } else {
                    if (wordStartIndex == -1) {
                        wordStartIndex = i;
                    }
                }
            }
            if (wordStartIndex != -1) {
                sb.append(text.substring(wordStartIndex));
            }
            for (int i = 0; i < extraSpaceCount; i++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}