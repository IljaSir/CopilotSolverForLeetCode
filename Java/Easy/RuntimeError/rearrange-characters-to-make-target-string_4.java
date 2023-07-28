class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        int[] count = new int[26];
        int[] targetCount = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            int n = count[i] / targetCount[i];
            max = Math.max(max, n);
        }
        return max;
    }
}