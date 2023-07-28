class Solution {
    public int nextGreaterElement(int n) {
        
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = digits.length - 1;
        while (j > i && digits[j] <= digits[i]) {
            j--;
        }
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        long val = Long.parseLong(new String(digits));
        return val > Integer.MAX_VALUE ? -1 : (int) val;
    }

    public void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public void reverse(char[] digits, int i, int j) {
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }
}