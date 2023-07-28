class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = Math.max(n1, n2);
        int[] result = new int[n + 1];
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int v1 = i < n1 ? arr1[n1 - i - 1] : 0;
            int v2 = i < n2 ? arr2[n2 - i - 1] : 0;
            int v = v1 + v2 + carry;
            if (v == 2) {
                v = 0;
                carry = 1;
            } else if (v == 3) {
                v = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            result[n - i] = v;
        }
        if (carry == 1) {
            result[0] = 1;
        }
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        if (i == result.length) {
            return new int[]{0};
        }
        int[] res = new int[result.length - i];
        System.arraycopy(result, i, res, 0, result.length - i);
        return res;
    }
}