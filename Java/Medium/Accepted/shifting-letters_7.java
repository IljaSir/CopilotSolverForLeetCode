class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        for(int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }
        char[] result = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int shift = shifts[i];
            int index = s.charAt(i) - 'a';
            int shiftedIndex = (index + shift) % 26;
            result[i] = (char) ('a' + shiftedIndex);
        }
        return new String(result);
    }
}