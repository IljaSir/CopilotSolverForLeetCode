class Solution {
    public int longestMountain(int[] arr) {
        
        int max = 0;
        int i = 0;
        while (i < arr.length) {
            int j = i;
            if (j + 1 < arr.length && arr[j] < arr[j + 1]) {
                while (j + 1 < arr.length && arr[j] < arr[j + 1]) {
                    j++;
                }
                if (j + 1 < arr.length && arr[j] > arr[j + 1]) {
                    while (j + 1 < arr.length && arr[j] > arr[j + 1]) {
                        j++;
                    }
                    max = Math.max(max, j - i + 1);
                }
            }
            i = Math.max(j, i + 1);
        }
        return max;
    }
}