class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int[] res = new int[Math.max(arr1.length, arr2.length) + 2];
        int i = arr1.length - 1, j = arr2.length - 1, k = res.length - 1;
        while (i >= 0 || j >= 0 || res[k] != 0) {
            if (i >= 0) res[k] += arr1[i--];
            if (j >= 0) res[k] += arr2[j--];
            if (res[k] > 1) {
                res[k - 1] += res[k] / 2;
                res[k] %= 2;
            }
            k--;
        }
        return Arrays.copyOfRange(res, k + 1, res.length);
    }
}