class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = Math.max(len1, len2);
        int[] res = new int[len + 2];
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int digit1 = i < len1 ? arr1[len1 - i - 1] : 0;
            int digit2 = i < len2 ? arr2[len2 - i - 1] : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 2;
            res[len + 1 - i] = sum % 2;
        }
        if (carry == 1) {
            res[0] = 1;
        }
        int start = 0;
        while (start < len + 2 && res[start] == 0) {
            start++;
        }
        return Arrays.copyOfRange(res, start, len + 2);
    }
}