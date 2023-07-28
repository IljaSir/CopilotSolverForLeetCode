class Solution {
    public String reverseOnlyLetters(String s) {
        
        char[] sArr = s.toCharArray();
        int i = 0;
        int j = sArr.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(sArr[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(sArr[j])) {
                j--;
            }
            char tmp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(sArr);
    }
}