class Solution {
    public long sumScores(String s) {
        
        long sum = 0;
        long score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i-1) == s.charAt(s.length() - 1 - i)) {
                score++;
            } else {
                score = 1;
            }
            sum += score;
        }
        return sum;
    }
}