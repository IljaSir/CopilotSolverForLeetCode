class Solution {
    public String makeGood(String s) {
        
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length - 1) {
            if (Math.abs(charArray[i] - charArray[i + 1]) == 32) {
                charArray = remove(charArray, i, i + 1);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return String.valueOf(charArray);
    }
    
    private char[] remove(char[] charArray, int i, int j) {
        char[] result = new char[charArray.length - 2];
        int k = 0;
        for (int m = 0; m < charArray.length; m++) {
            if (m != i && m != j) {
                result[k++] = charArray[m];
            }
        }
        return result;
    }
}