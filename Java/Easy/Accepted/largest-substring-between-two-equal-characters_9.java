class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (charIndex[index] == -1) {
                charIndex[index] = i;
            } else {
                max = Math.max(max, i - charIndex[index] - 1);
            }
        }
        return max;
    }
}