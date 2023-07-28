class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        
        int n = arr1.length;
        int[] p = new int[n];
        int[] q = new int[n];
        int[] r = new int[n];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = arr1[i] + arr2[i] + i;
            q[i] = arr1[i] + arr2[i] - i;
            r[i] = arr1[i] - arr2[i] + i;
            s[i] = arr1[i] - arr2[i] - i;
        }
        int ans = 0;
        ans = Math.max(ans, max(p) - min(p));
        ans = Math.max(ans, max(q) - min(q));
        ans = Math.max(ans, max(r) - min(r));
        ans = Math.max(ans, max(s) - min(s));
        return ans;
    }
    int max(int[] a) {
        int ans = a[0];
        for (int i = 1; i < a.length; i++) {
            ans = Math.max(ans, a[i]);
        }
        return ans;
    }
    int min(int[] a) {
        int ans = a[0];
        for (int i = 1; i < a.length; i++) {
            ans = Math.min(ans, a[i]);
        }
        return ans;
    }
}