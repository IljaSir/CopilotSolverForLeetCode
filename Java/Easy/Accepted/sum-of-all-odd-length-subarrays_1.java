class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i;
            int leftOdd = left / 2;
            int rightOdd = right / 2;
            int leftEven = (left + 1) / 2;
            int rightEven = (right + 1) / 2;
            sum += (leftOdd * rightOdd + leftEven * rightEven) * arr[i];
        }
        return sum;
    }
}