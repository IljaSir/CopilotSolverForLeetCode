class Solution {
    public int countValidWords(String sentence) {
        
        int count = 0;
        boolean isWord = false;
        boolean isHyphen = false;
        boolean isPunctuation = false;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ') {
                if (isWord) {
                    count++;
                }
                isWord = false;
                isHyphen = false;
                isPunctuation = false;
            } else if (ch == '-') {
                if (isHyphen || isPunctuation || !isWord) {
                    return 0;
                } else {
                    isHyphen = true;
                }
            } else if (ch == '!' || ch == '.' || ch == ',') {
                if (isPunctuation || !isWord) {
                    return 0;
                } else {
                    isPunctuation = true;
                }
            } else {
                if (isPunctuation) {
                    return 0;
                } else {
                    isWord = true;
                }
            }
        }
        if (isWord) {
            count++;
        }
        return count;
    }
}