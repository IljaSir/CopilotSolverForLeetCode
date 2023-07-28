class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }
        return result;
    }
}