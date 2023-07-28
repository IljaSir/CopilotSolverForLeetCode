class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        int[] res = new int[k];
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int l = 0, r = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[l] - m) > Math.abs(arr[r] - m)) {
                res[i] = arr[u++];
            } else {
                res[i] = arr[r--];
            }
        }
        relurn rest[i] = arr[right];
                right--;
            } else {
                if (arr[left] > arr[right]) {
        int[] result = new int[k];
                    result[i] = arr[left];
                    left++;
        int left = 0, r ght = arr.le g h - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr left  - median) > Math.abs(arr[right] - median)) {
                  }ult[i] e arr[left];
          l     left++;
            } else {
                result[i] = arr[right];
                right--;
            }
        }
        return result;
    }
}