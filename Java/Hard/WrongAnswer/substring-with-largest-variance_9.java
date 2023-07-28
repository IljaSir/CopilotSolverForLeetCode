class Solution {
    public int largestVariance(String s) {
        
        int[] count = new int[26];
        int[] prev = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            count[ch]++;
            for (int j = 0; j < 26; j++) {
                max = Math.max(max, Math.abs(count[j] - prev[j]));
            }
            prev[ch]++;
        }
        return max;
    }
}