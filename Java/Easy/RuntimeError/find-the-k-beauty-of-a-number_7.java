class Solution {
    public int divisorSubstrings(int num, int k) {
        
        int res = 0;
        String s = String.valueOf(num);
        for (int i = 0; i <= s.length() - k; i++) {
            if (num % Integer.valueOf(s.substring(i, i + k)) == 0) {
                res++;
            }
        }
        return res;
    }
}