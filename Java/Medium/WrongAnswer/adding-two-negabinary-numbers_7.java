class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        int max = Math.max(n, m);
        int[] res = new int[max + 2];
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int a = i < n ? arr1[n - 1 - i] : 0;
            int b = i < m ? arr2[m - 1 - i] : 0;
            int sum = a + b + carry;
            res[max - i] = sum & 1;
            carry = -(sum >> 1);
        }
        res[0] = carry;
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        return Arrays.copyOfRange(res, i, res.length);
    }
}