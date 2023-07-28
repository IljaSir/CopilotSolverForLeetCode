class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] res = new int[s.length()];
        int last = -s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) last = i;
            res[i] = i - last;
        }
        for (int i = last - 1; i >= 0; --i) {
            if (s.charAt(i) == c) last = i;
            res[i] = Math.min(res[i], last - i);
        }
        return res;
    }
}