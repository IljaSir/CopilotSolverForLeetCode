class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int start = 0, end = arr.length - 1;
            while(start <= i) {
                int len = i - start + 1;
                if(len % 2 != 0) {
                    sum += arr[i];
                }
                start++;
            }
            while(end >= i) {
                int len = end - i + 1;
                if(len % 2 != 0) {
                    sum += arr[i];
                }
                end--;
            }
        }
        return sum;
    }
}