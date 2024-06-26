class Solution {
    public int[] getStrongest(int[] arr, int k) {
        
        int[] result = new int[k];
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < k; i++) {
            if (Math.abs(arr[left] - median) > Math.abs(arr[right] - median)) {
                result[i] = arr[left];
                left++;
            } else if (Math.abs(arr[left] - median) < Math.abs(arr[right] - median)) {
                result[i] = arr[right];
                right--;
            } else {
                if (arr[left] > arr[right]) {
                    result[i] = arr[left];
                    left++;
                } else {
                    result[i] = arr[right];
                    right--;
                }
            }
        }
        return result;
    }
}