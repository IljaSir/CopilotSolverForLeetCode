class Solution {
    public int waysToMakeFair(int[] nums) {
        
        int n = nums.length;
        int[] odd = new int[n];
        int[] even = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i] = nums[i];
            } else {
                odd[i] = nums[i];
            }
        }
        int[] sumOdd = new int[n];
        int[] sumEven = new int[n];
        sumOdd[0] = odd[0];
        sumEven[0] = even[0];
        for (int i = 1; i < n; i++) {
            sumOdd[i] = sumOdd[i - 1] + odd[i];
            sumEven[i] = sumEven[i - 1] + even[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int oddSum = 0;
            int evenSum = 0;
            if (i > 0) {
                oddSum += sumOdd[i - 1];
                evenSum += sumEven[i - 1];
            }
            if (i + 1 < n) {
                oddSum += sumEven[n - 1] - sumEven[i];
                evenSum += sumOdd[n - 1] - sumOdd[i];
            }
            if (oddSum == evenSum) {
                result++;
            }
        }
        return result;
    }
}