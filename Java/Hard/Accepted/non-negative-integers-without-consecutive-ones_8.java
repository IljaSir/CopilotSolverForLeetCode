class Solution {
    public int findIntegers(int n) {
        
        String s = Integer.toBinaryString(n);
        int len = s.length();
        int[] a = new int[len];
        int[] b = new int[len];
        a[0] = b[0] = 1;
        for (int i = 1; i < len; ++i) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        int ans = a[len - 1] + b[len - 1];
        for (int i = 1; i < len; ++i) {
            if (s.charAt(i - 1) == '1' && s.charAt(i) == '1') {
                break;
            } else if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                ans -= b[len - i - 1];
            }
        }
        return ans;
    }
}