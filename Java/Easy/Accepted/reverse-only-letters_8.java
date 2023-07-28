class Solution {
    public String reverseOnlyLetters(String s) {
        
        int i = 0, j = s.length() - 1;
        char[] sArray = s.toCharArray();
        while (i < j) {
            if (!Character.isLetter(sArray[i])) {
                i++;
            } else if (!Character.isLetter(sArray[j])) {
                j--;
            } else {
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(sArray);
    }
}