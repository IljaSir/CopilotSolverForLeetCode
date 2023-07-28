class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        int[] res = new int[k];
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int left = 0, right = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[left] - m) > Math.abs(arr[right] - m)) {
                res[i] = arr[left];
                left++;
            } else {
                res[i] = arr[right];
                right--;
            }
        }
        return res;
    }
}