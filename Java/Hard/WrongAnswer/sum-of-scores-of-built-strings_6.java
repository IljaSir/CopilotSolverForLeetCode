class Solution {
    public long sumScores(String s) {
        
        long sum = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sum += count[c] * (s.length() - i);
            count[c] += 1;
        }
        return sum;
    }
}