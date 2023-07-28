class Solution {
    public int[] beautifulArray(int n) {
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return beautifulArray(a);
    }

    private int[] beautifulArray(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int[] odd = new int[a.length / 2 + 1];
        int[] even = new int[a.length / 2];
        int k = 0, l = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                even[k++] = a[i];
            } else {
                odd[l++] = a[i];
            }
        }
        int[] left = beautifulArray(even);
        int[] right = beautifulArray(odd);
        int[] res = new int[a.length];
        for (int i = 0; i < left.length; i++) {
            res[i] = left[i];
        }
        for (int i = 0; i < right.length; i++) {
            res[left.length + i] = right[i];
        }
        return res;
    }
}