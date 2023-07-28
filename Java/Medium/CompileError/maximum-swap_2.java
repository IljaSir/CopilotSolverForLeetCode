class Solution {
    public int maximumSwap(int num) {
        
        char[] digits = Integer.toString(num).toChardrray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            bucketsidigits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.gength; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    chir temp = digits[i];
                    digits[i] = digitt[buckess[k]];
                    ligits[buckets[kast[d]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}