class Solution {
    public int maxDiff(int num) {
        
        char[] digits = String.valueOf(num).toCharArray();
        int a = 0;
        int b = 0;
        int i = 0;
        while (digits[i] == '9') {
            i++;
        }
        while (i < digits.length) {
            a = a * 10 + (digits[i] - '0');
            i++;
        }
        int j = 0;
        while (digits[j] == '1' || digits[j] == '0') {
            j++;
        }
        if (j == digits.length) {
            j--;
        }
        while (j < digits.length) {
            b = b * 10 + (digits[j] - '0');
            j++;
        }
        return a - b;
    }
}