class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            sum %= 26;
            shifts[i] = sum;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - 'a' + shifts[i]) % 26 + 'a');
        }
        return new String(chars);
    }
}