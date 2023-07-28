class Solution {
    public long numberOfWays(String s) {
        
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        long result = 0;
        long target = count / 3;
        if (target == 0) {
            return (count - 2) * (count - 1) / 2 % 1000000007;
        }
        long temp = 0;
        long first = 0;
        long second = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                temp++;
            }
            if (temp == target) {
                first++;
            }
            if (temp == target * 2) {
                second++;
            }
        }
        return first * second % 1000000007;
    }
}