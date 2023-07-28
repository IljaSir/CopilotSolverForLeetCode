class Solution {
    public long numberOfWays(String s) {
        
        long count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return ((long)s.length() - 1) * ((long)s.length() - 2) / 2;
        }
        long k = count / 3;
        long first = 0;
        long second = 0;
        count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                count++;
            }
            if (count == k) {
                first++;
            }
            if (count == k * 2) {
                second++;
            }
        }
        return first * second;
    }
}