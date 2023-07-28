class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        String ns = String.valueOf(n);
        int[] digits = new int[10];
        for (int i = 0; i < ns.length(); i++) {
            digits[ns.charAt(i) - '0']++;
        }
        for (int i = 0; i < 31; i++) {
            int[] digits2 = new int[10];
            String ns2 = String.valueOf(1 << i);
            for (int j = 0; j < ns2.length(); j++) {
                digits2[ns2.charAt(j) - '0']++;
            }
            if (Arrays.equals(digits, digits2)) {
                return true;
            }
        }
        return false;
    }
}