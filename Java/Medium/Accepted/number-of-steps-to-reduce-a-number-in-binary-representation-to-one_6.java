class Solution {
    public int numSteps(String s) {
        
        int step = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int cur = s.charAt(i) - '0';
            if (carry == 0) {
                if (cur == 0) {
                    step++;
                } else {
                    step += 2;
                    carry = 1;
                }
            } else {
                if (cur == 0) {
                    step += 2;
                } else {
                    step++;
                    carry = 1;
                }
            }
        }
        return step + carry;
    }
}