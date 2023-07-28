class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] bits = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bits[i] = Integer.bitCount(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (bits[i] > bits[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = bits[i];
                    bits[i] = bits[j];
                    bits[j] = temp;
                } else if (bits[i] == bits[j]) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        temp = bits[i];
                        bits[i] = bits[j];
                        bits[j] = temp;
                    }
                }
            }
        }
        return arr;
    }
}