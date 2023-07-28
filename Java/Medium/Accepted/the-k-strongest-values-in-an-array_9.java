class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int[] res = new int[k];
        int l = 0, r = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[l] - median) > Math.abs(arr[r] - median)) {
                res[i] = arr[l++];
            } else {
                res[i] = arr[r--];
            }
        }
        return res;
    }
}