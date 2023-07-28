class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        int[] sum = new int[shifts.length];
        int sumOfShifts = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            sumOfShifts += shifts[i];
            sumOfShifts %= 26;
            sum[i] = sumOfShifts;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + (chars[i] - 'a' + sum[i]) % 26);
        }
        return new String(chars);
    }
}