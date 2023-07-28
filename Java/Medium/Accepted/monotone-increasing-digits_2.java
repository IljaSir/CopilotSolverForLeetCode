class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        char[] arr = String.valueOf(n).toCharArray();
        int i = 1;
        while (i < arr.length && arr[i - 1] <= arr[i]) {
            i++;
        }
        if (i < arr.length) {
            while (i > 0 && arr[i - 1] > arr[i]) {
                arr[i - 1]--;
                i--;
            }
            for (i++; i < arr.length; i++) {
                arr[i] = '9';
            }
        }
        return Integer.parseInt(new String(arr));
    }
}