class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            chars[i] = (char) ((chars[i] - 'a' + sum) % 26 + 'a');
        }
        return new String(chars);
    }
}