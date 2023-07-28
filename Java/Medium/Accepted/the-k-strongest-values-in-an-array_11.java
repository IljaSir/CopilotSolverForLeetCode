class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        int[] res = new int[k];
        int n = arr.length;
        Arrays.sort(arr);
        int median = arr[(n - 1) / 2];
        int l = 0, r = n - 1;
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