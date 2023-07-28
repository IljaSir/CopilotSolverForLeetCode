class Solution {
    public int maxScore(String s) {
        
        int max = 0;
        int[] zero = new int[s.length()];
        int[] one = new int[s.length()];
        zero[0] = s.charAt(0) == '0' ? 1 : 0;
        one[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            zero[i] = zero[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            one[i] = one[i + 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, zero[i] + one[i + 1]);
        }
        return max;
    }
}