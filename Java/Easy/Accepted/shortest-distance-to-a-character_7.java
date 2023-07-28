class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        int cPos = Integer.MIN_VALUE / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                cPos = i;
            }
            result[i] = i - cPos;
        }
        cPos = Integer.MAX_VALUE / 2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                cPos = i;
            }
            result[i] = Math.min(result[i], cPos - i);
        }
        return result;
    }
}