class Solution {
    public long sumScores(String s) {
        
        long score = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            int max = 0;
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, count[j]);
            }
            score += max;
        }
        return score;
    }
}