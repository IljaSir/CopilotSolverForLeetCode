class Solution {
    public int balancedString(String s) {
        
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] > s.length() / 4) {
                result += map[i] - s.length() / 4;
            }
        }
        return result;
    }
}