class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        int carry = 0;
        for(int i = s.length() - 1; i >= 1; i--) {
            if(s.charAt(i) == '0' && carry == 1) {
                steps++;
            } else if(s.charAt(i) == '1' && carry == 1) {
                steps += 2;
            } else if(s.charAt(i) == '1' && carry == 0) {
                steps++;
            }
            carry = s.charAt(i) == '1' ? 1 : 0;
        }
        
        return steps + carry;
    }
}