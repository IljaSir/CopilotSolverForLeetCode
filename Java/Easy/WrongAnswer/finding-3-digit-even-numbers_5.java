class Solution {
    public int[] findEvenNumbers(int[] digits) {
        
        int[] res = new int[100];
        int j = 0;
        for(int i = 0; i < digits.length; i++) {
            for(int k = 0; k < digits.length; k++) {
                if(k == i) continue;
                for(int l = 0; l < digits.length; l++) {
                    if(l == i || l == k) continue;
                    int num = digits[i] * 100 + digits[k] * 10 + digits[l];
                    if(num % 2 == 0) {
                        res[j++] = num;
                    }
                }
            }
        }
        int[] result = new int[j];
        for(int i = 0; i < j; i++) {
            result[i] = res[i];
        }
        return result;
    }
}