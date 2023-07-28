class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        int max = -1;
        for (int i = 0; i < 26; i++) {
            if (first[i] >= 0 && last[i] >= 0 && first[i] != last[i]) {
                max = Math.max(max, last[i] - first[i] - 1);
            }
        }
        return max;
    }
}