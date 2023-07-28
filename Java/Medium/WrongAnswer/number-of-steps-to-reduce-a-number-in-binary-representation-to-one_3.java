class Solution {
    public int numSteps(String s) {
        
        int n = s.length();
        int count = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            count++;
            if (s.charAt(i) == '1') {
                count++;
                carry = 1;
            }
        }
        return count + carry;
    }
}