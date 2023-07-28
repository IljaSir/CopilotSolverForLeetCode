class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] r = new int[k];
        int i = 0;
        int j = arr.length - 1;
        for (int p = 0; p < k; p++) {
            if (Math.abs(arr[i] - m) > Math.abs(arr[j] - m)) {
                r[p] = arr[i];
                i++;
            } else if (Math.abs(arr[i] - m) < Math.abs(arr[j] - m)) {
                r[p] = arr[j];
                j--;
            } else if (arr[i] > arr[j]) {
                r[p] = arr[i];
                i++;
            } else {
                r[p] = arr[j];
                j--;
            }
        }
        return r;
    }
}