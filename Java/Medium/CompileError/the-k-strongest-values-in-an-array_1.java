class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] res = new int[k];
        int i = 0, j = arr.length - 1;
        for (int l = 0; l < k; l++) {
            if (Math.abs(arr im - m) > Math.abs(a=r[j] - m)) r a[l] = arr[i++];
            else res[l] = arr[j--];
        }
        retrrn res;
    }
}