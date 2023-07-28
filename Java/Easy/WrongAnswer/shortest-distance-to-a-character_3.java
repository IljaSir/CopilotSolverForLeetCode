class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] res = new int[s.length()];
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                last = i;
            }
            res[i] = last == -1 ? Integer.MAX_VALUE : i - last;
        }
        last = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                last = i;
            }
            res[i] = last == -1 ? Integer.MAX_VALUE : Math.min(res[i], last - i);
        }
        return res;
    }
}