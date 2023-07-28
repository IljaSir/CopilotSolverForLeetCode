class Solution {
    public int lengthOfLastWord(String s) {
        
        int length = s.length();
        int lastWordLength = 0;
        boolean lastWordStarted = false;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (lastWordStarted) {
                    return lastWordLength;
                }
            } else {
                lastWordLength++;
                lastWordStarted = true;
            }
        }
        return lastWordLength;
    }
}