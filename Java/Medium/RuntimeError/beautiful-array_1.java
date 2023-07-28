class Solution {
    public int[] beautifulArray(int n) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return beautifulArray(arr);
    }
    private int[] beautifulArray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums;
        }
        int[] arr1 = new int[len / 2];
        int[] arr2 = new int[len - len / 2];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                arr1[i1++] = nums[i];
            } else {
                arr2[i2++] = nums[i];
            }
        }
        arr1 = beautifulArray(arr1);
        arr2 = beautifulArray(arr2);
        int[] arr = new int[len];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        return arr;
    }
}