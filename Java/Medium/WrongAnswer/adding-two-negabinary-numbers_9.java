class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l = Math.max(l1, l2);
        int[] res = new int[l + 2];
        int i = l1 - 1, j = l2 - 1, k = l + 1;
        while (i >= 0 || j >= 0) {
            res[k] += (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0);
            if (res[k] > 1) {
                res[k - 1]++;
                res[k] -= 2;
            }
            i--;
            j--;
            k--;
        }
        while (k > 1) {
            if (res[k] > 1) {
                res[k - 1]++;
                res[k] -= 2;
            }
            k--;
        }
        k = 0;
        while (k < l + 2 && res[k] == 0) {
            k++;
        }
        return Arrays.copyOfRange(res, k, l + 2);
    }
}