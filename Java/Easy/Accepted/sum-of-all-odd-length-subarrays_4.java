class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - i;
            int leftEven = (left + 1) / 2;
            int rightEven = (right + 1) / 2;
            int leftOdd = left / 2;
            int rightOdd = right / 2;
            sum += (leftEven * rightEven + leftOdd * rightOdd) * arr[i];
        }
        return sum;
    }
}