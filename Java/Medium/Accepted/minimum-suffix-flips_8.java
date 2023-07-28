class Solution {
    public int minFlips(String target) {
        
        char[] t = target.toCharArray();
        int n = t.length;
        int res = 0;
        char c = '0';
        for (int i = 0; i < n; i++) {
            if (t[i] == c) continue;
            res++;
            c = t[i];
        }
        return res;
    }
}