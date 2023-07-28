class Solution {
    public int minimizeXor(int num1, int num2) {
        
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((num1 & 1 << i) != (num2 & 1 << i)) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}