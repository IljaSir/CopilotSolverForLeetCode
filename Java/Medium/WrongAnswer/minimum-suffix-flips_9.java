class Solution {
    public int minFlips(String target) {
        
        int res = 0, n = target.length();
        char[] chs = target.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chs[i] == '1') {
                res++;
                while (i < n && chs[i] == '1') {
                    i++;
                }
            }
        }
        return res;
    }
}