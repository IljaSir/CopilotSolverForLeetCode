class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int sum = 0;
        while (arr.length > 1) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                int product = arr[i] * arr[i + 1];
                if (product < min) {
                    min = product;
                    minIndex = i;
                }
            }
            sum += min;
            arr[minIndex] = Math.max(arr[minIndex], arr[minIndex + 1]);
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < minIndex; i++) {
                newArr[i] = arr[i];
            }
            for (int i = minIndex + 1; i < arr.length; i++) {
                newArr[i - 1] = arr[i];
            }
            arr = newArr;
        }
        return sum;
    }
}