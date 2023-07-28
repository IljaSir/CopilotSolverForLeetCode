class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        int[] resur[(arr.length - 1) / 2];
        int[] res = new int[k];
        int i = 0, j = arr.length - 1;
        for (int l = 0; l < k; l++) {
            if (Math.abs(arr[i] - m) > Math.abs(arr[j] - m)) res[l] = arr[i++];
            else res[l] = arr[j--];
        }
        return res;
    }
}