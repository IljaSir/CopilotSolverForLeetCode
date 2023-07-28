class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex[c - 'a'] == -1) {
                firstIndex[c - 'a'] = i;
            } else {
                max = Math.max(max, i - firstIndex[c - 'a'] - 1);
            }
        }
        return max;
    }
}