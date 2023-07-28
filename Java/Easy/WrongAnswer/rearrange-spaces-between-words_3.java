class Solution {
    public String reorderSpaces(String text) {
        
        int spaces = 0;
        int words = 0;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                spaces++;
            }
        }
        String[] wordsArr = text.trim().split("\\s+");
        words = wordsArr.length;
        int spacesBetween = words > 1 ? spaces / (words - 1) : spaces;
        int spacesEnd = words > 1 ? spaces % (words - 1) : 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordsArr.length; i++) {
            sb.append(wordsArr[i]);
            if (i < wordsArr.length - 1) {
                for (int j = 0; j < spacesBetween; j++) {
                    sb.append(' ');
                }
            }
        }
        for (int i = 0; i < spacesEnd; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}