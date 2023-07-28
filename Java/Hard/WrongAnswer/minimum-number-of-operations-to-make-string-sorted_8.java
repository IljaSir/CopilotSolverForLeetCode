class Solution {
    public int makeStringSorted(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        long fact = 1;
        long mod = 1000000007;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.charAt(i) - 'a'; j++) {
                if (count[j] == 0) {
                    continue;
                }
                long a = fact;
                count[j]--;
                for (int k = 0; k < 26; k++) {
                    a = a * modInverse(count[k], mod) % mod;
                }
                result = (result + a) % mod;
                count[j]++;
            }
            fact = fact * (s.length() - i) % mod;
            count[s.charAt(i) - 'a']--;
        }
        return (int) result;
    }

    private long modInverse(long a, long m) {
        long m0 = m;
        long y = 0;
        long x = 1;
        if (m == 1) {
            return 0;
        }
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) {
            x += m0;
        }
        return x;
    }
}