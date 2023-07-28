class Solution {
    public int numWays(String s) {
        
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        if (ones % 3 != 0) {
            return 0;
        }
        if (ones == 0) {
            return (int) (((long) (s.length() - 1) * (s.length() - 2) / 2) % 1000000007);
        }
        ones /= 3;
        int first = 0;
        int second = 0;
        int current = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                current++;
            }
            if (current == ones) {
                first++;
            }
            if (current == ones * 2) {
                second++;
            }
        }
        return (int) ((long) first * second % 1000000007);
    }
}