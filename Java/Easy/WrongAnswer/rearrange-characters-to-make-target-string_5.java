class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        if (s.length() < target.length()) {
            return 0;
        }
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        for (char c : s.toCharArray()) {
            sCount[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            tCount[c - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (tCount[i] > 0) {
                max = Math.max(max, sCount[i] / tCount[i]);
            }
        }
        return max;
    }
}