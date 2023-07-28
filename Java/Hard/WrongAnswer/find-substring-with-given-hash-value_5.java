class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        int hash = 0;
        for (int i = 0; i < k; i++) {
            hash = (hash + (s.charAt(i) - 'a' + 1) * power(i, power, modulo)) % modulo;
        }
        if (hash == hashValue) {
            return s.substring(0, k);
        }
        for (int i = k; i < s.length(); i++) {
            hash = (hash - (s.charAt(i - k) - 'a' + 1) * power(i - k, power, modulo) + modulo) % modulo;
            hash = (hash * power + s.charAt(i) - 'a' + 1) % modulo;
            if (hash == hashValue) {
                return s.substring(i - k + 1, i + 1);
            }
        }
        return "";
    }

    public int power(int exp, int power, int modulo) {
        int res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * power) % modulo;
            }
            exp >>= 1;
            power = (power * power) % modulo;
        }
        return res;
    }
}