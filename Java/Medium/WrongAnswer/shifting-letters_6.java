class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        char[] chars = s.toCharArray();
        int len = shifts.length;
        for (int i = len - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
        }
        for (int i = 0; i < len; i++) {
            int newChar = (chars[i] - 'a' + shifts[i]) % 26;
            chars[i] = (char) (newChar + 'a');
        }
        return new String(chars);
    }
}