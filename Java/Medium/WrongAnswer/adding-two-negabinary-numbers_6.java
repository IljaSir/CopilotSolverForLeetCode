class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        int max = Math.max(n, m);
        int[] ans = new int[max + 2];
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int a = i < n ? arr1[n - 1 - i] : 0;
            int b = i < m ? arr2[m - 1 - i] : 0;
            ans[i] += a + b + carry;
            carry = ans[i] >> 1;
            ans[i] &= 1;
        }
        ans[max] = carry;
        int i = max + 1;
        while (i > 0 && ans[i] == 0) {
            i--;
        }
        return Arrays.copyOfRange(ans, 0, i + 1);
    }
}