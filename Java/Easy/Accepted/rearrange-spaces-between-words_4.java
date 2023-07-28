class Solution {
    public String reorderSpaces(String text) {
        
        int spaceCount = 0;
        List<String> words = new ArrayList<String>();
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
                if (word.length() > 0) {
                    words.add(word);
                    word = "";
                }
            } else {
                word += text.charAt(i);
            }
        }
        if (word.length() > 0) {
            words.add(word);
        }
        String result = "";
        if (words.size() == 1) {
            result = words.get(0);
            for (int i = 0; i < spaceCount; i++) {
                result += " ";
            }
        } else {
            int spacesBetweenWords = spaceCount / (words.size() - 1);
            int remainingSpaces = spaceCount % (words.size() - 1);
            for (int i = 0; i < words.size(); i++) {
                result += words.get(i);
                if (i < words.size() - 1) {
                    for (int j = 0; j < spacesBetweenWords; j++) {
                        result += " ";
                    }
                }
            }
            for (int i = 0; i < remainingSpaces; i++) {
                result += " ";
            }
        }
        return result;
    }
}