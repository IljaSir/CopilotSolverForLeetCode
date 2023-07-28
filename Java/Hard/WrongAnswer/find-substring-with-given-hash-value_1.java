class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        int p = 1;
        for (int i = 0; i < k; i++) {
            p = (p * power) % modulo;
        }
        int h = 0;
        for (int i = 0; i < k; i++) {
            h = (h * power + s.charAt(i) - 'a' + 1) % modulo;
        }
        if (h == hashValue) {
            return s.substring(0, k);
        }
        for (int i = k; i < s.length(); i++) {
            h = (h * power + s.charAt(i) - 'a' + 1 - (s.charAt(i - k) - 'a' + 1) * p) % modulo;
            if (h < 0) {
                h += modulo;
            }
            if (h == hashValue) {
                return s.substring(i - k + 1, i + 1);
            }
        }
        return "";
    }
}