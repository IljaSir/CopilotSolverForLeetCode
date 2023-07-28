class Solution {
    public int minimumScore(String s, String t) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                result += Math.abs(count[i]);
                min = Math.min(min, Math.abs(count[i]));
            }
        }
        return result - min;
    }
}