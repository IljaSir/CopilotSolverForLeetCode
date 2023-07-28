class Solution {
    public int[] diStringMatch(String s) {
        
        int n = s.length();
        int[] res = new int[n+1];
        int lo = 0;
        int hi = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = lo++;
            } else {
                res[i] = hi--;
            }
        }
        res[n] = lo;
        return res;
    }
}