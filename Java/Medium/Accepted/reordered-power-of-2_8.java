class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        int[] digits = new int[10];
        int n1 = n;
        while (n1 > 0) {
            digits[n1 % 10]++;
            n1 /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int[] digits1 = new int[10];
            int n2 = 1 << i;
            while (n2 > 0) {
                digits1[n2 % 10]++;
                n2 /= 10;
            }
            if (Arrays.equals(digits, digits1)) {
                return true;
            }
        }
        return false;
    }
}