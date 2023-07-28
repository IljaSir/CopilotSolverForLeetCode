class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        int n = s.length();
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (int) ((1L * pows[i - 1] * power) % modulo);
        }
        int[] hash = new int[n];
        hash[0] = s.charAt(0) - 'a' + 1;
        for (int i = 1; i < n; i++) {
            hash[i] = (int) ((1L * hash[i - 1] * power + s.charAt(i) - 'a' + 1) % modulo);
        }
        for (int i = 0; i < n - k + 1; i++) {
            int h = hash[i + k - 1];
            if (i > 0) {
                h = (int) ((1L * h - hash[i - 1] * 1L * pows[k]) % modulo);
                if (h < 0) {
                    h += modulo;
                }
            }
            if (h == hashValue) {
                return s.substring(i, i + k);
            }
        }
        return "";
    }
}