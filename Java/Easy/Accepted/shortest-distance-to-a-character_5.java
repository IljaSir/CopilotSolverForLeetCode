class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] res = new int[s.length()];
        int lastC = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                lastC = i;
            }
            res[i] = lastC == -1 ? Integer.MAX_VALUE : i - lastC;
        }
        lastC = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                lastC = i;
            }
            if (lastC != -1) {
                res[i] = Math.min(res[i], Math.abs(lastC - i));
            }
        }
        return res;
    }
}