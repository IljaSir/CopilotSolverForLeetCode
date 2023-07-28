class Solution {
    public int[] beautifulArray(int n) {
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return beautifulArray(arr);
    }
    
    public int[] beautifulArray(int[] arr) {
        if (arr.length < 3) {
            return arr;
        }
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                left[i / 2] = arr[i];
            } else {
                right[i / 2] = arr[i];
            }
        }
        int[] leftSorted = beautifulArray(left);
        int[] rightSorted = beautifulArray(right);
        int[] result = new int[arr.length];
        for (int i = 0; i < leftSorted.length; i++) {
            result[i] = leftSorted[i];
        }
        for (int i = 0; i < rightSorted.length; i++) {
            result[i + leftSorted.length] = rightSorted[i];
        }
        return result;
    }
}