class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '0' && carry == 0) {
                steps++;
            } else if (s.charAt(i) == '0' && carry == 1) {
                steps += 2;
                carry = 1;
            } else if (s.charAt(i) == '1' && carry == 0) {
                steps++;
                carry = 1;
            } else if (s.charAt(i) == '1' && carry == 1) {
                steps++;
            }
        }
        return steps + carry;
    }
}